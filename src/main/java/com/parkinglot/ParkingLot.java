package com.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLot {
    private Car car;
    private Car parkedCar;
    private Map<ParkingTicket, Car> parkedPosition;
    private final static int DEFAULT_CAPACITY = 10;
    private ParkingTicket ticketCount;
    private int capacity;

    public ParkingLot(){this(DEFAULT_CAPACITY);}

    public ParkingLot(int capacity){
        parkedPosition = new HashMap<>();
        this.capacity = capacity;
    }

    public ParkingTicket park(Car car){
            if(capacity==parkedPosition.size()){
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

    public Car findCarFromParkingLot(){
        return   parkedPosition
                    .entrySet()
                    .stream()
                    .filter(cars -> this.car.equals(cars.getValue()))
                    .map(Map.Entry::getValue)
                    .findFirst()
                    .orElse(null);
    }

    public boolean isParkingLotFull(){
        return capacity==parkedPosition.size();
    }
}

