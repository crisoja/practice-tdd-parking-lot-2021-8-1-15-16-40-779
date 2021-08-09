package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Car car;
    private Car parkedCar;
    private Map<ParkingTicket, Car> parkedPosition;
    private final static int DEFAULT_CAPACITY = 10;
    private ParkingTicket parkingTicket;

    public int getCapacity() {
        return capacity;
    }

    private int capacity;

    public ParkingLot() {
        this(DEFAULT_CAPACITY);
    }

    public ParkingLot(int capacity) {
        parkedPosition = new HashMap<>();
        this.capacity = capacity;
    }

    public ParkingTicket park(Car car) {

        if (capacity == parkedPosition.size()) {
            throw new NoAvailablePositionException();
        }

        this.car = car;
        ParkingTicket parkingTicket = new ParkingTicket();
        parkedPosition.put(parkingTicket, car);
        this.parkingTicket = parkingTicket;

        return this.parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {

        if (!parkedPosition.containsKey(parkingTicket)) {
            throw new UnrecognizedParkingTicketException();
        }
        parkedCar = parkedPosition.get(parkingTicket);
        parkedPosition.remove(parkingTicket, car);
        return parkedCar;
    }

    public Car findCarFromParkingLot() {
        return parkedPosition
                .entrySet()
                .stream()
                .filter(parkingTicket -> this.parkingTicket.equals(parkingTicket.getKey()))
                .map(parkingTicket -> parkingTicket.getValue())
                .findFirst()
                .orElse(null);
    }

    public boolean isParkingLotFull() {
        return capacity == parkedPosition.size();
    }

    public boolean checkTicket(ParkingTicket parkingTicket) {
        return parkedPosition.containsKey(parkingTicket);
    }

    public int getParkedPositionSize() {
        return parkedPosition.size();
    }

    public boolean findCaratParkingLot(Car car) {
        return parkedPosition.containsValue(car);

    }
}

