package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SmartStandardParkingBoy extends StandardParkingBoy {

    public SmartStandardParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public SmartStandardParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    @Override
    public ParkingTicket park(Car car) {
        if (parkingLots != null) {
            return parkingLots.stream()
                    .max(Comparator.comparing(this::getLargestAvailableSpace))
                    .map(parkingLot -> parkingLot.park(car))
                    .orElse(null);
        }
        return parkingLot.park(car);
    }
}
