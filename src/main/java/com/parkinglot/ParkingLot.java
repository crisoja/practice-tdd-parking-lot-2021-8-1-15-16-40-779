package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Car car;
    private Car parkedCar;
    private Map<ParkingTicket, Car> parkedPosition = new HashMap<>();
    private final int CAPACITY = 10;
    private ParkingTicket ticketCount;

    public ParkingTicket park(Car car){
            if(CAPACITY==parkedPosition.size()){
                throw new NoAvailablePositionException();
            }

            this.car = car;
            ParkingTicket parkingTicket = new ParkingTicket();
            parkedPosition.put(parkingTicket, car);
            ticketCount = parkingTicket;

        return ticketCount;
    }

    public Car fetch(ParkingTicket parkingTicket)throws Exception{

            if(!parkedPosition.containsKey(parkingTicket)){
               throw new UnrecognizedParkingTicketException();
            }
            parkedCar =  parkedPosition.get(parkingTicket);
            parkedPosition.remove(parkingTicket, car);
            return parkedCar;
    }
}

