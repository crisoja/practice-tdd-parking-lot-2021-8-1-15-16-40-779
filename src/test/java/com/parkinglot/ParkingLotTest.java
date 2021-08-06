package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ParkingLotTest {
    @Test
    void should_return_parking_ticket_when_park_given_a_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = parkingLot.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_car_when_fetch_given_a_parking_lot_with_a_parked_car_and_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);

        //when
        Car actualCar = parkingLot.fetch(parkingTicket);

        //then
        assertEquals(car, actualCar);
    }

    @Test
    void shoul_return_the_right_car_when_fetch_twice_given_a_parking_lot_with_two_parked_cars_and_two_parking_tickets() {

        //given
        ParkingLot parkingLot = new ParkingLot();
        Car montemayorCar = new Car();
        Car alisonCar = new Car();
        ParkingTicket montemayorParkingTicket = parkingLot.park(montemayorCar);
        ParkingTicket alisonParkingTicket = parkingLot.park(alisonCar);

        //when
        Car actualMontemayorCar = parkingLot.fetch(montemayorParkingTicket);
        Car actualAlisonCar = parkingLot.fetch(alisonParkingTicket);

        //then
        assertEquals(montemayorCar, actualMontemayorCar);
        assertEquals(alisonCar, actualAlisonCar);
    }

    @Test
    void should_return_nothing_when_fetch_the_car_given_a_wrong_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = new ParkingTicket();

        //when
        Car carWithWrongParkingTicket = parkingLot.fetch(new ParkingTicket());

        //then
        assertNull(carWithWrongParkingTicket);
    }

    @Test
    void should_return_nothing_when_fetch_the_car_given_used_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = new ParkingTicket();

        //when
        Car usedParkingTicket = parkingLot.fetch(parkingTicket);

        //then
        assertNull(usedParkingTicket);
    }

    @Test
    void should_return_nothing_when_park_the_car_given_parking_lot_without_any_position_and_a_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when
        ParkingTicket parkingTicket =  parkingLot.park(car);

        //then
        assertNull(parkingTicket);

    }
}


