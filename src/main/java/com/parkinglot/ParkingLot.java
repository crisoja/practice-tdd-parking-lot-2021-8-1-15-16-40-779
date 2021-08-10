package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Car car;
    private Car parkedCar;
    private Map<ParkingTicket, Car> parkedPositions;
    private final static int DEFAULT_PARKING_LOT_CAPACITY = 10;
    private ParkingTicket parkingTicket;

    public int getCapacity() {
        return capacity;
    }

    private int capacity;

    public ParkingLot() {
        this(DEFAULT_PARKING_LOT_CAPACITY);
    }

    public ParkingLot(int capacity) {
        parkedPositions = new HashMap<>();
        this.capacity = capacity;
    }

    public ParkingTicket park(Car car) {

        if (capacity == parkedPositions.size()) {
            throw new NoAvailablePositionException();
        }

        this.car = car;
        ParkingTicket parkingTicket = new ParkingTicket();
        parkedPositions.put(parkingTicket, car);
        this.parkingTicket = parkingTicket;

        return this.parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {

        if (!parkedPositions.containsKey(parkingTicket)) {
            throw new UnrecognizedParkingTicketException();
        }
        parkedCar = parkedPositions.get(parkingTicket);
        parkedPositions.remove(parkingTicket, car);
        return parkedCar;
    }

    public Car findCarFromParkingLot() {
        return parkedPositions
                .entrySet()
                .stream()
                .filter(parkingTicket -> this.parkingTicket.equals(parkingTicket.getKey()))
                .map(parkingTicket -> parkingTicket.getValue())
                .findFirst()
                .orElse(null);
    }

    public boolean isParkingLotFull() {
        return capacity == parkedPositions.size();
    }

    public boolean checkTicket(ParkingTicket parkingTicket) {
        return parkedPositions.containsKey(parkingTicket);
    }

    public int getParkedPositionSize() {
        return parkedPositions.size();
    }

    public boolean findCaratParkingLot(Car car) {
        return parkedPositions.containsValue(car);

    }
}

