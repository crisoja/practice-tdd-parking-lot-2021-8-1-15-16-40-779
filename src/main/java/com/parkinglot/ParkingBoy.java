package com.parkinglot;

import java.util.List;

public abstract class ParkingBoy {
    ParkingLot parkingLot;
    List<ParkingLot> parkingLots;
    Car car = new Car();

    abstract ParkingTicket park(Car car);

}
