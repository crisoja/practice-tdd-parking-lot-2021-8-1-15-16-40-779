package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SuperSmartStandardParkingBoy extends StandardParkingBoy {
    public SuperSmartStandardParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SuperSmartStandardParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {

        return parkingLots.stream()
                .max(Comparator.comparing(this::getAvailablePositionRate))
                .map(parkingLot -> parkingLot.park(car))
                .orElse(null);
    }
}
