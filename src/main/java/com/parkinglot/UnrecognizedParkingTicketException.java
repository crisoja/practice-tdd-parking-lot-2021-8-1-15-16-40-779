package com.parkinglot;

public class UnrecognizedParkingTicketException extends RuntimeException{

    public static final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized parking ticket";

    @Override
    public String getMessage(){
        return UNRECOGNIZED_PARKING_TICKET;
    }
}
