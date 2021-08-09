package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuperSmartParkingBoyTest {

    @Test
    void should_throw_Unrecognized_parking_ticket_when_standard_parking_boy_fetch_the_car_given_a_super_smart_parking_boy_who_manage_two_parking_lot_and_an_unrecognized_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket = new ParkingTicket();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot);

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
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotList);
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
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotList);
        ParkingTicket parkingTicket1 = superSmartParkingBoy.park(firstCar);
        ParkingTicket parkingTicket2 = superSmartParkingBoy.park(secondCar);

        //when & then
        Exception exception = assertThrows(Exception.class, () -> superSmartParkingBoy.park(thirdCar));
        {
            assertTrue(exception.getMessage().contains("No available position"));
        }
    }
}
