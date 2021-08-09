package com.parkinglot;

import java.util.List;

public class SuperSmartStandardParkingBoy extends StandardParkingBoy {
    private double size;
    private double capacity;
    private
    ParkingLot parkingLot;
    public SuperSmartStandardParkingBoy(ParkingLot parkingLot){
        super(parkingLot);
    }
    public SuperSmartStandardParkingBoy(List<ParkingLot> parkingLotList){
        super(parkingLotList);
    }

    @Override
    public ParkingTicket park(Car car){
       if(getAvailablePositionRate(parkingLotList.get(0)) >=  getAvailablePositionRate(parkingLotList.get(1))){
        return  parkingLotList.get(0).park(car);
       }
       else if(size==capacity){
           parkingLot = parkingLotList.get(0);
           parkingLot = parkingLotList.get(1);
           return parkingLot.park(car);
       }
        return  parkingLotList.get(0).park(car);
    }

    public double getAvailablePositionRate(ParkingLot parkingLot){
         size = parkingLot.getCapacity() - parkingLot.getParkedPositionSize();
         capacity = parkingLot.getCapacity();
        return size/capacity;

    }
}
