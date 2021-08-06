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
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        Car car7 = new Car();
        Car car8 = new Car();
        Car car9 = new Car();
        Car car10 = new Car();
        Car car11 = new Car();
        ParkingTicket parkingTicket1 =  parkingLot.park(car1);
        ParkingTicket parkingTicket2 =  parkingLot.park(car2);
        ParkingTicket parkingTicket3 =  parkingLot.park(car3);
        ParkingTicket parkingTicket4 =  parkingLot.park(car4);
        ParkingTicket parkingTicket5 =  parkingLot.park(car5);
        ParkingTicket parkingTicket6 =  parkingLot.park(car6);
        ParkingTicket parkingTicket7 =  parkingLot.park(car7);
        ParkingTicket parkingTicket8 =  parkingLot.park(car8);
        ParkingTicket parkingTicket9 =  parkingLot.park(car9);
        ParkingTicket parkingTicket10 =  parkingLot.park(car10);

        //when
        ParkingTicket parkingTicket11 =  parkingLot.park(car11);

        //then
        assertNull(parkingTicket11);

    }
}


