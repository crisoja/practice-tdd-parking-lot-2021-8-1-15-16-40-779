package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class StandardParkingBoy extends ParkingBoy{

    public StandardParkingBoy(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }
    public StandardParkingBoy(List<ParkingLot> parkingLotList){
        this.parkingLotList = parkingLotList;
    }

    @Override
    public ParkingTicket park(Car car){
        this.car = car;
        if(parkingLotList!=null){
         return    parkingLotList.stream()
                    .filter(parkingLot -> !parkingLot.isParkingLotFull())
                    .map(parkingLot -> parkingLot.park(car))
                    .findFirst()
                    .orElseThrow(NoAvailablePositionException::new);
        }
        return parkingLot.park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) throws Exception {
        if(parkingLotList!=null) {

         return    parkingLotList.stream()
                    .filter(parkingLot -> parkingLot.checkTicket(parkingTicket))
                    .map(parkingLot -> parkingLot.fetch(parkingTicket))
                    .findAny()
                    .orElseThrow(UnrecognizedParkingTicketException::new);
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
