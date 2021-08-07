package com.parkinglot;

import java.util.Objects;

public class Car {
    ParkingTicket parkingTicket;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(parkingTicket, car.parkingTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingTicket);
    }
}
