package com.parkinglot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import javax.sql.rowset.serial.SerialStruct;
import java.util.ArrayList;
import java.util.List;

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
    void should_return_car_when_fetch_given_a_parking_lot_with_a_parked_car_and_parking_ticket() throws Exception {
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
    void shoul_return_the_right_car_when_fetch_twice_given_a_parking_lot_with_two_parked_cars_and_two_parking_tickets() throws Exception {

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
    void should_throw_error_message_Unrecognized_parking_ticket_when_fetch_the_car_given_a_wrong_parking_ticket() throws Exception {

        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = new ParkingTicket();


        //when & then
        Exception exception = assertThrows(Exception.class, () -> parkingLot.fetch(parkingTicket));
        {
            assertTrue(exception.getMessage().contains("Unrecognized parking ticket"));
        }
    }
    @Test
    void should_throw_error_message_Unrecognized_parking_ticket_when_fetch_the_car_given_a_parking_lot_and_used_parking_ticket() throws Exception {

        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        parkingLot.fetch(parkingTicket);

        //when & then
        Exception exception = assertThrows(Exception.class, () -> parkingLot.fetch(parkingTicket));
        assertTrue(exception.getMessage().contains("Unrecognized parking ticket"));
    }

    @Test
    void should_throw_error_message_No_available_position_when_park_the_car_given_a_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();

        for (int i = 0; i < 10; i++) {
            parkingLot.park(new Car());
        }

        //when & then
        Exception exception = assertThrows(Exception.class, () -> parkingLot.park(new Car()));
        assertTrue(exception.getMessage().contains("No available position"));
    }

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
        Car actualCar =  parkingboy.fetch(parkingTicket);

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

    @Test
    void should_throw_error_message_Unrecognized_parking_ticket_when_parking_boy_fetch_the_car_given_a_wrong_parking_ticket() throws Exception {

        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = new ParkingTicket();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when & then
        Exception exception = assertThrows(Exception.class, () -> parkingBoy.fetch(parkingTicket));
        {
            assertTrue(exception.getMessage().contains("Unrecognized parking ticket"));
        }
    }
    @Test
    void should_throw_error_message_Unrecognized_parking_ticket_when_parking_boy_fetch_the_car_given_a_parking_lot_and_used_parking_ticket() throws Exception {

        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        parkingLot.fetch(parkingTicket);

        //when & then
        Exception exception = assertThrows(Exception.class, () -> parkingBoy.fetch(parkingTicket));
        assertTrue(exception.getMessage().contains("Unrecognized parking ticket"));
    }

    @Test
    void should_throw_error_message_No_available_position_when_parking_boy_park_the_car_given_a_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingBoy.park(new Car());

        //when & then
        Exception exception = assertThrows(Exception.class, () -> parkingBoy.park(new Car()));
        assertTrue(exception.getMessage().contains("No available position"));
    }

    @Test
    void should_car_park_to_the_first_parking_lot_when_standard_parking_boy_park_the_car_given_standard_parking_boy_who_manage_two_parking_lots_both_with_available_position_and_a_car() {
       //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot());
        parkingLotList.add(new ParkingLot());
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);

        //when
        parkingBoy.park(car);

        //then
        assertEquals(car, parkingBoy.getCarFromFirstParkingLot(car));

    }
//    Given a standard parking boy, who manage two parking lots, first is full and second with available position, and a car
//    When park the car
//    THen the car will be parked to the second parking lot

    @Test
    void should_car_park_to_the_second_parking_lot_when_standard_parking_boy_park_the_car_given_standard_parking_boy_manage_two_parking_lots_first_is_full_and_second_availbale_and_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot(1));
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        ParkingTicket firstCarparkingTicket = parkingLotList.get(0).park(firstCar);

        //when
        parkingBoy.park(secondCar);

        //then
        assertEquals(secondCar, parkingBoy.getCarFromSecondParkingLot(secondCar));
    }
}
