package com.parkinglot;

import java.util.List;

public class StandardParkingBoy extends ParkingBoy {

    public StandardParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        this.car = car;
        if (parkingLots != null) {
            return parkingLots.stream()
                    .filter(parkingLot -> !parkingLot.isParkingLotFull())
                    .findFirst()
                    .map(parkingLot -> parkingLot.park(car))
                    .orElseThrow(NoAvailablePositionException::new);
        }
        return parkingLot.park(car);
    }
}
