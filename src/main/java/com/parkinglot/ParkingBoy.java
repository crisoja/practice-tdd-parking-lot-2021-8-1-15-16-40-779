package com.parkinglot;

import java.util.List;

public abstract class ParkingBoy {
    ParkingLot parkingLot;
    List<ParkingLot> parkingLotList;
    Car car = new Car();

    abstract ParkingTicket park(Car car);

}
