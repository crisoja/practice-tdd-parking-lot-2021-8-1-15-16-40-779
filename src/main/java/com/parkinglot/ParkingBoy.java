package com.parkinglot;

import java.util.List;

public abstract class ParkingBoy {
    ParkingLot parkingLot;
    List<ParkingLot> parkingLots;
    Car car = new Car();

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    abstract ParkingTicket park(Car car);

    public Car fetch(ParkingTicket parkingTicket) throws Exception {
        if (parkingLots != null) {
            return parkingLots.stream()
                    .filter(parkingLot -> parkingLot.checkTicket(parkingTicket))
                    .map(parkingLot -> parkingLot.fetch(parkingTicket))
                    .findAny()
                    .orElseThrow(UnrecognizedParkingTicketException::new);
        }
        return parkingLot.fetch(parkingTicket);
    }

    public Car getCarFromFirstParkingLot() {
        return parkingLots.stream()
                .findFirst()
                .map(ParkingLot::findCarFromParkingLot)
                .orElse(null);
    }

    public Car getCarFromOtherParkingLot() {
        return parkingLots.stream()
                .filter(parkingLot -> !getCarFromFirstParkingLot().equals(parkingLot.findCarFromParkingLot()))
                .map(ParkingLot::getCar)
                .findAny()
                .orElse(null);
    }

    public int getLargestAvailableSpace(ParkingLot parkingLot) {
        return parkingLot.getCapacity() - parkingLot.getParkedPositionSize();
    }

    public double getAvailablePositionRate(ParkingLot parkingLot) {
        return (parkingLot.getCapacity() - parkingLot.getParkedPositionSize()) / parkingLot.getCapacity();
    }
}