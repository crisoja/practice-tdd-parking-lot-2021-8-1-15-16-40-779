package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest{

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
        assertTrue(parkingLotList.get(0).findCaratParkingLot(newCar));
    }


}
