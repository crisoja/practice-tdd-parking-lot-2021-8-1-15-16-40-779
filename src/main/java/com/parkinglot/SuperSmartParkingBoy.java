package com.parkinglot;

import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{

    public SuperSmartParkingBoy(ParkingLot parkingLot){
        super(parkingLot);
    }
    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList){
        super(parkingLotList);
    }

    @Override
    public ParkingTicket park(Car car){
        return null;
    }
}
