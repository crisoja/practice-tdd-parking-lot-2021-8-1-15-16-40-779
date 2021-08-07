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
       if(getAvailablePositionRate(parkingLotList.get(0)) >=  getAvailablePositionRate(parkingLotList.get(1))){
        return  parkingLotList.get(0).park(car);
       }
        return  parkingLotList.get(0).park(car);
    }

    public double getAvailablePositionRate(ParkingLot parkingLot){
        double size = parkingLot.getCapacity() - parkingLot.getParkedPositionSize();
        double capacity = parkingLot.getCapacity();
        double positionRate = size/capacity;
        return positionRate;

    }
}
