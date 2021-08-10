package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartStandardParkingBoyTest {


    @Test
    void should_smart_parking_boy_park_to_first_parking_lot_when_smart_parking_boy_park_the_car_given_a_smart_parking_boy_who_manage_two_parking_lot_both_with_available_position_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot());
        parkingLotList.add(new ParkingLot());
        Car car = new Car();
        SmartStandardParkingBoy smartParkingBoy = new SmartStandardParkingBoy(parkingLotList);

        //when
        smartParkingBoy.park(car);

        //then
        assertEquals(car, smartParkingBoy.getCarFromFirstParkingLot());
    }

    @Test
    void should_park_to_the_second_parking_lot_when_smart_parking_boy_park_the_car_given_smart_parking_boy_manage_two_parking_lot_first_parking_lot_has_less_position_than_second_parking_lot_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(2));
        parkingLotList.add(new ParkingLot(2));
        Car firstCar = new Car();
        Car secondCar = new Car();
        SmartStandardParkingBoy smartParkingBoy = new SmartStandardParkingBoy(parkingLotList);
        ParkingTicket firstCarparkingTicket = parkingLotList.get(0).park(firstCar);

        //when
        smartParkingBoy.park(secondCar);

        //then
        assertEquals(secondCar, smartParkingBoy.getCarFromOtherParkingLot());
    }

    @Test
    void should_park_to_the_first_parking_lot_when_smart_parking_boy_park_the_car_given_smart_parking_boy_manage_two_parking_lot_second_parking_lot_has_less_position_than_first_parking_lot_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(2));
        parkingLotList.add(new ParkingLot(2));
        Car firstCar = new Car();
        Car secondCar = new Car();
        SmartStandardParkingBoy smartParkingBoy = new SmartStandardParkingBoy(parkingLotList);
        ParkingTicket firstCarparkingTicket = parkingLotList.get(1).park(firstCar);

        //when
        smartParkingBoy.park(secondCar);

        //then
        assertEquals(secondCar, smartParkingBoy.getCarFromFirstParkingLot());
    }

    @Test
    void should_return_the_right_car_with_each_ticket_when_smart_parking_boy_fetch_the_car_twice_given_smart_parking_boy_manage_two_parking_lots_bot_with_a_parked_car_and_two_parking_ticket() throws Exception {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot());
        SmartStandardParkingBoy smartParkingBoy = new SmartStandardParkingBoy(parkingLotList);
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
        SmartStandardParkingBoy smartParkingBoy = new SmartStandardParkingBoy(parkingLot);

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
        SmartStandardParkingBoy smartParkingBoy = new SmartStandardParkingBoy(parkingLotList);
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
        SmartStandardParkingBoy smartParkingBoy = new SmartStandardParkingBoy(parkingLotList);
        ParkingTicket parkingTicket1 = smartParkingBoy.park(firstCar);
        ParkingTicket parkingTicket2 = smartParkingBoy.park(secondCar);

        //when & then
        Exception exception = assertThrows(Exception.class, () -> smartParkingBoy.park(thirdCar));
        {
            assertTrue(exception.getMessage().contains("No available position"));
        }
    }



}
