package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Car car;
    private Car parkedCar;
    private Map<ParkingTicket, Car> parkedPosition = new HashMap<>();

    public ParkingTicket park(Car car){
        this.car = car;
        ParkingTicket parkingTicket = new ParkingTicket();
        parkedPosition.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket){

        if(parkedPosition.containsKey(parkingTicket)){
            parkedCar =  parkedPosition.get(parkingTicket);
            parkedPosition.remove(parkingTicket, car);
            car = parkedCar;
        }


        return car;
    }
}
