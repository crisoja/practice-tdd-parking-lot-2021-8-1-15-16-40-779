package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    ParkingLot parkingLot;
    List<ParkingLot> parkingLotList;
    Car car = new Car();

    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }
    public ParkingBoy(List<ParkingLot> parkingLotList){
        this.parkingLotList = parkingLotList;
    }

    public ParkingTicket park(Car car){
        this.car = car;
        if(parkingLotList!=null){
         return    parkingLotList.stream()
                    .filter(parkingLot -> !parkingLot.isParkingLotFull())
                    .map(parkingLot -> parkingLot.park(car))
                    .findFirst()
                    .orElse(null);
        }

        return parkingLot.park(car);

    }

    public Car fetch(ParkingTicket parkingTicket) throws Exception {
        if(parkingLotList!=null) {
            if (parkingLotList.get(0).checkTicket(parkingTicket))
                return parkingLotList.get(0).fetch(parkingTicket);
            else if(parkingLotList.get(1).checkTicket(parkingTicket))
                return parkingLotList.get(1).fetch(parkingTicket);
            else
                throw new UnrecognizedParkingTicketException();
        }
        return parkingLot.fetch(parkingTicket);
    }

    public Car getCarFromFirstParkingLot(Car car) {
        return parkingLotList.get(0).findCarFromParkingLot();

    }

    public Car getCarFromSecondParkingLot(Car Car) {
        return parkingLotList.get(1).findCarFromParkingLot();
    }
}
