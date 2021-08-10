package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StandardParkingBoyTest {



    @Test
    void should_throw_error_message_No_available_position_when_parking_boy_park_the_car_given_a_parking_lot_and_a_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        standardParkingBoy.park(new Car());

        //when & then
        Exception exception = assertThrows(Exception.class, () -> standardParkingBoy.park(new Car()));
        assertTrue(exception.getMessage().contains("No available position"));
    }

    @Test
    void should_car_park_to_the_first_parking_lot_when_standard_parking_boy_park_the_car_given_standard_parking_boy_who_manage_two_parking_lots_both_with_available_position_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot());
        parkingLotList.add(new ParkingLot());
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);

        //when
        standardParkingBoy.park(car);

        //then
        assertEquals(car, standardParkingBoy.getCarFromFirstParkingLot());

    }

    @Test
    void should_car_park_to_the_second_parking_lot_when_standard_parking_boy_park_the_car_given_standard_parking_boy_manage_two_parking_lots_first_is_full_and_second_availbale_and_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot(1));
        Car firstCar = new Car();
        Car secondCar = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
        ParkingTicket firstCarparkingTicket = parkingLotList.get(0).park(firstCar);

        //when
        standardParkingBoy.park(secondCar);

        //then
        assertEquals(secondCar, standardParkingBoy.getCarFromSecondParkingLot(secondCar));
    }

    @Test
    void should_return_the_right_car_with_each_ticket_when_standard_parking_boy_fetch_the_car_twice_given_standard_parking_boy_manage_two_parking_lots_bot_with_a_parked_car_and_two_parking_ticket() throws Exception {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot());
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingTicket firstCarparkingTicket = standardParkingBoy.park(firstCar);
        ParkingTicket secondCarparkingTicket = standardParkingBoy.park(secondCar);

        //when
        Car firstCarFetch = standardParkingBoy.fetch(firstCarparkingTicket);
        Car secondCarFetch = standardParkingBoy.fetch(secondCarparkingTicket);

        //then
        assertEquals(firstCar, firstCarFetch);
        assertEquals(secondCar, secondCarFetch);
    }


    @Test
    void should_return_a_parking_ticket_when_parking_boy_park_the_car_given_a_parking_lot_and_a_car() {
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = standardParkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_the_the_actual_car_when_parking_boy_fetch_the_car_given_a_parking_lot_with_a_parked_car_and_a_parking_ticket() throws Exception {
        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy parkingboy = new StandardParkingBoy(parkingLot);
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
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car montemayorCar = new Car();
        Car alisonCar = new Car();

        ParkingTicket montemayorParkingTicket = parkingLot.park(montemayorCar);
        ParkingTicket alisonParkingTicket = parkingLot.park(alisonCar);

        //when
        Car actualMontemayorCar = standardParkingBoy.fetch(montemayorParkingTicket);
        Car actualAlisonCar = standardParkingBoy.fetch(alisonParkingTicket);

        //then
        assertEquals(montemayorCar, actualMontemayorCar);
        assertEquals(alisonCar, actualAlisonCar);
    }

    @Test
    void should_throw_error_message_Unrecognized_parking_ticket_when_standard_parking_boy_fetch_the_car_given_a_standard_parking_boy_who_manage_two_parking_lots_and_a_unrecognized_ticekt() throws Exception {

        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot());
        parkingLotList.add(new ParkingLot());
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
        Car car = new Car();
        ParkingTicket parkingTicket = standardParkingBoy.park(car);


        //when & then
        Exception exception = assertThrows(Exception.class, () -> standardParkingBoy.fetch(new ParkingTicket()));
        {
            assertTrue(exception.getMessage().contains("Unrecognized parking ticket"));
        }
    }
    @Test
    void should_throw_error_message_Unrecognized_parking_ticket_when_parking_boy_fetch_the_car_given_a_wrong_parking_ticket() throws Exception {

        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = new ParkingTicket();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);

        //when & then
        Exception exception = assertThrows(Exception.class, () -> standardParkingBoy.fetch(parkingTicket));
        {
            assertTrue(exception.getMessage().contains("Unrecognized parking ticket"));
        }
    }

    @Test
    void should_throw_error_message_Unrecognized_parking_ticket_when_parking_boy_fetch_the_car_given_a_parking_lot_and_used_parking_ticket() throws Exception {

        //given
        ParkingLot parkingLot = new ParkingLot();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLot);
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        parkingLot.fetch(parkingTicket);

        //when & then
        Exception exception = assertThrows(Exception.class, () -> standardParkingBoy.fetch(parkingTicket));
        assertTrue(exception.getMessage().contains("Unrecognized parking ticket"));
    }

    @Test
    void should_throw_error_message_Unrecognized_parking_ticket_when_standard_parking_boy_fetch_the_car_given_a_standard_parking_boy_who_manage_two_parking_lots_and_a_used_ticket() throws Exception {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot());
        parkingLotList.add(new ParkingLot());
        Car car = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
        ParkingTicket parkingTicket = standardParkingBoy.park(car);
        standardParkingBoy.fetch(parkingTicket);

        //when & then
        Exception exception = assertThrows(Exception.class, () -> standardParkingBoy.fetch(parkingTicket));
        {
            assertTrue(exception.getMessage().contains("Unrecognized parking ticket"));
        }
    }

    @Test
    void should_throw_error_message_No_available_position_when_standard_parking_boy_park_the_car_given_a_standard_parking_boy_who_manage_two_parking_lots_bot_without_any_position_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot(1));
        Car firstCar = new Car();
        Car secondCar = new Car();
        Car thirdCar = new Car();
        StandardParkingBoy standardParkingBoy = new StandardParkingBoy(parkingLotList);
        ParkingTicket parkingTicket1 = standardParkingBoy.park(firstCar);
        ParkingTicket parkingTicket2 = standardParkingBoy.park(secondCar);

        //when & then
        Exception exception = assertThrows(Exception.class, () -> standardParkingBoy.park(thirdCar));
        {
            assertTrue(exception.getMessage().contains("No available position"));
        }
    }

}

