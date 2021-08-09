package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SuperSmartStandardParkingBoy extends StandardParkingBoy {
    public SuperSmartStandardParkingBoy(ParkingLot parkingLot){
        super(parkingLot);
    }
    public SuperSmartStandardParkingBoy(List<ParkingLot> parkingLotList){
        super(parkingLotList);
    }

    @Override
    public ParkingTicket park(Car car){

     return   parkingLotList.stream()
                .max(Comparator.comparing(parkingLot ->getAvailablePositionRate(parkingLot)))
                .map(parkingLot -> parkingLot.park(car))
                .orElse(null);
    }

    public double getAvailablePositionRate(ParkingLot parkingLot){
        return (parkingLot.getCapacity() - parkingLot.getParkedPositionSize()) / parkingLot.getCapacity();

    }
}
