package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SuperSmartStandardParkingBoyTest {

    @Test
    void should_throw_Unrecognized_parking_ticket_when_standard_parking_boy_fetch_the_car_given_a_super_smart_parking_boy_who_manage_two_parking_lot_and_an_unrecognized_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = new ParkingTicket();
        SuperSmartStandardParkingBoy superSmartParkingBoy = new SuperSmartStandardParkingBoy(parkingLot);

        //when & then
        Exception exception = assertThrows(Exception.class, () -> superSmartParkingBoy.fetch(parkingTicket));
        {
            assertTrue(exception.getMessage().contains("Unrecognized parking ticket"));
        }
    }

    @Test
    void should_throw_error_message_Unrecognized_parking_ticket_when_super_smart_parking_boy_fetch_the_car_given_a_super_smart_parking_boy_who_manage_two_parking_lots_and_a_used_ticket() throws Exception {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot());
        parkingLotList.add(new ParkingLot());
        Car car = new Car();
        SuperSmartStandardParkingBoy superSmartParkingBoy = new SuperSmartStandardParkingBoy(parkingLotList);
        ParkingTicket parkingTicket = superSmartParkingBoy.park(car);
        superSmartParkingBoy.fetch(parkingTicket);

        //when & then
        Exception exception = assertThrows(Exception.class, () -> superSmartParkingBoy.fetch(parkingTicket));
        {
            assertTrue(exception.getMessage().contains("Unrecognized parking ticket"));
        }
    }

    @Test
    void should_throw_error_message_No_available_position_when_super_smart_parking_boy_park_the_car_given_a_super_smart_parking_boy_who_manage_two_parking_lots_bot_without_any_position_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(1));
        parkingLotList.add(new ParkingLot(1));
        Car firstCar = new Car();
        Car secondCar = new Car();
        Car thirdCar = new Car();
        SuperSmartStandardParkingBoy superSmartParkingBoy = new SuperSmartStandardParkingBoy(parkingLotList);
        ParkingTicket parkingTicket1 = superSmartParkingBoy.park(firstCar);
        ParkingTicket parkingTicket2 = superSmartParkingBoy.park(secondCar);

        //when & then
        Exception exception = assertThrows(Exception.class, () -> superSmartParkingBoy.park(thirdCar));
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
        SuperSmartStandardParkingBoy superSmartParkingBoy = new SuperSmartStandardParkingBoy(parkingLotList);

        //when
        superSmartParkingBoy.park(car);

        //then
        assertEquals(car, superSmartParkingBoy.getCarFromFirstParkingLot());
    }

    @Test
    void should_park_to_the_first_parking_lot_when_smart_parking_boy_park_the_car_given_smart_parking_boy_manage_two_parking_lot_first_parking_lot_has_larger_available_position_rate_than_second_parking_lot_and_a_car() {
        //given
        List<ParkingLot> parkingLotList = new ArrayList<>();
        parkingLotList.add(new ParkingLot(15));
        parkingLotList.add(new ParkingLot(20));

        SuperSmartStandardParkingBoy superSmartParkingBoy = new SuperSmartStandardParkingBoy(parkingLotList);
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
        assertTrue(parkingLotList.get(0).findCarAtParkingLot(newCar));
    }

}
