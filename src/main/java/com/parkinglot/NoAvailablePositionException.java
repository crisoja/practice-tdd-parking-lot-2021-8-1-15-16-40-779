package com.parkinglot;

public class NoAvailablePositionException extends RuntimeException {

    public static final String NO_AVAILABLE_POSITION = "No available position";

    @Override
    public String getMessage() {
        return NO_AVAILABLE_POSITION;
    }
}
