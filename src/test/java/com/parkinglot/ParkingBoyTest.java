package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingBoyTest {

    @Test
    void should_return_a_parking_ticket_when_parking_boy_park_the_car_given_a_parking_lot_and_a_car() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_the_the_actual_car_when_parking_boy_fetch_the_car_given_a_parking_lot_with_a_parked_car_and_a_parking_ticket() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingboy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);

        //when
        Car actualCar = parkingboy.fetch(parkingTicket);

        //then
        assertEquals(car, actualCar);
    }

    @Test
    void should_return_right_car_when_parking_boy_fetch_the_car_twice_given_parking_lot_with_two_parked_cars_and_two_parking_ticket() throws Exception {

        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car montemayorCar = new Car();
        Car alisonCar = new Car();

        ParkingTicket montemayorParkingTicket = parkingLot.park(montemayorCar);
        ParkingTicket alisonParkingTicket = parkingLot.park(alisonCar);

        //when
        Car actualMontemayorCar = parkingBoy.fetch(montemayorParkingTicket);
        Car actualAlisonCar = parkingBoy.fetch(alisonParkingTicket);

        //then
        assertEquals(montemayorCar, actualMontemayorCar);
        assertEquals(alisonCar, actualAlisonCar);
    }
}

