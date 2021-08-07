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

    @Test
    void should_return_the_right_car_with_each_ticket_when_standard_parking_boy_fetch_the_car_twice_given_standard_parking_boy_manage_two_parking_lots_bot_with_a_parked_car_and_two_parking_ticket() throws Exception {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingTicket firstCarparkingTicket = parkingBoy.park(firstCar);
        ParkingTicket secondCarparkingTicket = parkingBoy.park(secondCar);

        //when
        Car firstCarFetch = parkingBoy.fetch(firstCarparkingTicket);
        Car secondCarFetch = parkingBoy.fetch(secondCarparkingTicket);

        //then
        assertEquals(firstCar, firstCarFetch);
        assertEquals(secondCar, secondCarFetch);
    }


    @Test
    void should_throw_error_message_Unrecognized_parking_ticket_when_standard_parking_boy_fetch_the_car_given_a_standard_parking_boy_who_manage_two_parking_lots_and_a_unrecognized_ticekt() throws Exception {

        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot());
        parkingLotList.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car);


        //when & then
        Exception exception = assertThrows(Exception.class, () -> parkingBoy.fetch(new ParkingTicket()));
        {
            assertTrue(exception.getMessage().contains("Unrecognized parking ticket"));
        }
    }

    @Test
    void should_throw_error_message_Unrecognized_parking_ticket_when_standard_parking_boy_fetch_the_car_given_a_standard_parking_boy_who_manage_two_parking_lots_and_a_used_ticket() throws Exception {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot());
        parkingLotList.add(new ParkingLot());
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        ParkingTicket parkingTicket = parkingBoy.park(car);
        parkingBoy.fetch(parkingTicket);

        //when & then
        Exception exception = assertThrows(Exception.class, () -> parkingBoy.fetch(parkingTicket));
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
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        ParkingTicket parkingTicket1 = parkingBoy.park(firstCar);
        ParkingTicket parkingTicket2 = parkingBoy.park(secondCar);

       //when & then
        Exception exception = assertThrows(Exception.class, () -> parkingBoy.park(thirdCar));
        {
            assertTrue(exception.getMessage().contains("No available position"));
        }
    }

    @Test
    void should_smart_parking_boy_park_to_first_parking_lot_when_smart_parking_boy_park_the_car_given_a_smart_parking_boy_who_manage_two_parking_lot_both_with_available_position_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot());
        parkingLotList.add(new ParkingLot());
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);

        //when
        smartParkingBoy.park(car);

        //then
        assertEquals(car, smartParkingBoy.getCarFromFirstParkingLot(car));
    }

    @Test
    void should_park_to_the_second_parking_lot_when_smart_parking_boy_park_the_car_given_smart_parking_boy_manage_two_parking_lot_first_parking_lot_has_less_position_than_second_parking_lot_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(2));
        parkingLotList.add(new ParkingLot(2));
        Car firstCar = new Car();
        Car secondCar = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        ParkingTicket firstCarparkingTicket = parkingLotList.get(0).park(firstCar);

        //when
        smartParkingBoy.park(secondCar);

        //then
        assertEquals(secondCar, smartParkingBoy.getCarFromSecondParkingLot(secondCar));
    }

    @Test
    void should_park_to_the_first_parking_lot_when_smart_parking_boy_park_the_car_given_smart_parking_boy_manage_two_parking_lot_second_parking_lot_has_less_position_than_first_parking_lot_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(2));
        parkingLotList.add(new ParkingLot(2));
        Car firstCar = new Car();
        Car secondCar = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        ParkingTicket firstCarparkingTicket = parkingLotList.get(1).park(firstCar);

        //when
        smartParkingBoy.park(secondCar);

        //then
        assertEquals(secondCar, smartParkingBoy.getCarFromFirstParkingLot(secondCar));
    }

    @Test
    void should_return_the_right_car_with_each_ticket_when_smart_parking_boy_fetch_the_car_twice_given_smart_parking_boy_manage_two_parking_lots_bot_with_a_parked_car_and_two_parking_ticket() throws Exception {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingTicket firstCarparkingTicket = smartParkingBoy.park(firstCar);
        ParkingTicket secondCarparkingTicket = smartParkingBoy.park(secondCar);

        //when
        Car firstCarFetch = smartParkingBoy.fetch(firstCarparkingTicket);
        Car secondCarFetch = smartParkingBoy.fetch(secondCarparkingTicket);

        //then
        assertEquals(firstCar, firstCarFetch);
        assertEquals(secondCar, secondCarFetch);
    }

    @Test
    void should_throw_error_message_Unrecognized_parking_ticket_when_standard_parking_boy_fetch_the_car_given_a_smart_parking_boy_who_manage_two_parking_lots_and_unrecognized_ticket() {

        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = new ParkingTicket();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);

        //when & then
        Exception exception = assertThrows(Exception.class, () -> smartParkingBoy.fetch(parkingTicket));
        {
            assertTrue(exception.getMessage().contains("Unrecognized parking ticket"));
        }
    }
    @Test
    void should_throw_error_message_Unrecognized_parking_ticket_when_smart_parking_boy_fetch_the_car_given_a_smart_parking_boy_who_manage_two_parking_lots_and_a_used_ticket() throws Exception {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot());
        parkingLotList.add(new ParkingLot());
        Car car = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        ParkingTicket parkingTicket = smartParkingBoy.park(car);
        smartParkingBoy.fetch(parkingTicket);

        //when & then
        Exception exception = assertThrows(Exception.class, () -> smartParkingBoy.fetch(parkingTicket));
        {
            assertTrue(exception.getMessage().contains("Unrecognized parking ticket"));
        }
    }


    @Test
    void should_throw_error_message_No_available_position_when_smart_parking_boy_park_the_car_given_a_smart_parking_boy_who_manage_two_parking_lots_bot_without_any_position_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot(1));
        Car firstCar = new Car();
        Car secondCar = new Car();
        Car thirdCar = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        ParkingTicket parkingTicket1 = smartParkingBoy.park(firstCar);
        ParkingTicket parkingTicket2 = smartParkingBoy.park(secondCar);

        //when & then
        Exception exception = assertThrows(Exception.class, () -> smartParkingBoy.park(thirdCar));
        {
            assertTrue(exception.getMessage().contains("No available position"));
        }
    }

    @Test
    void should_super_smart_parking_boy_park_to_first_parking_lot_when_super_smart_parking_boy_park_the_car_given_a_super_smart_parking_boy_who_manage_two_parking_lot_both_with_available_position_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot());
        parkingLotList.add(new ParkingLot());
        Car car = new Car();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotList);

        //when
        superSmartParkingBoy.park(car);

        //then
        assertEquals(car, superSmartParkingBoy.getCarFromFirstParkingLot(car));
    }

    @Test
    void should_park_to_the_first_parking_lot_when_smart_parking_boy_park_the_car_given_smart_parking_boy_manage_two_parking_lot_first_parking_lot_has_larger_available_position_rate_than_second_parking_lot_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(15));
        parkingLotList.add(new ParkingLot(20));

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotList);
        for (int i = 0; i < 3; i++) {
            parkingLotList.get(0).park(new Car());
        }
        for (int i = 0; i < 5; i++) {
            parkingLotList.get(1).park(new Car());
        }

        //when
        Car newCar = new Car();
        superSmartParkingBoy.park(newCar);

        //then
        assertTrue(parkingLotList.get(0).parisCarAtfirstParkingLot(newCar));
    }
}

