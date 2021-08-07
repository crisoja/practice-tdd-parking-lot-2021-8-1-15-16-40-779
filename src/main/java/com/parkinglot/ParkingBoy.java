package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    ParkingLot parkingLot;
    List<ParkingLot> parkingLotList;

    public ParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }
    public ParkingBoy(List<ParkingLot> parkingLotList){
        this.parkingLotList = parkingLotList;
    }

    public ParkingTicket park(Car car){
        if(parkingLotList==null){
            return parkingLot.park(car);
        }
       return parkingLotList.get(0).park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) throws Exception {
        parkingLotList = new ArrayList<>();
        return parkingLot.fetch(parkingTicket);
    }

    public Car getCarFromFirstParkingLot(Car car) {
        return parkingLotList.get(0).findCarFromParkingLot();

    }
}
