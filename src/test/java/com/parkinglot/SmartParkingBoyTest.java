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
}
