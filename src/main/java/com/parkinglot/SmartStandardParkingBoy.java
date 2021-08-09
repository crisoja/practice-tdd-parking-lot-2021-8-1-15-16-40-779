package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SmartStandardParkingBoy extends StandardParkingBoy {

    public SmartStandardParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    public SmartStandardParkingBoy(ParkingLot parkingLot){
        super(parkingLot);
    }

    @Override
    public ParkingTicket park(Car car) {
        if (parkingLotList != null) {
            return parkingLotList.stream()
                    .min(Comparator.comparing(parkingLot -> parkingLot.getParkedPositionSize()))
                    .map(parkingLot -> parkingLot.park(car))
                    .orElse(null);
        }
        return parkingLot.park(car);

    }
}