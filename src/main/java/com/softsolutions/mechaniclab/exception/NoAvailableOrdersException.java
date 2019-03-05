package com.softsolutions.mechaniclab.exception;

public class NoAvailableOrdersException extends Exception {

    public NoAvailableOrdersException() {
        super("There are no available orders");
    }
}
