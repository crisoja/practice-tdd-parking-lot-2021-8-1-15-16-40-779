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

}
