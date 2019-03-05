package com.softsolutions.mechaniclab.exception;

public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(Class clazz, Number number) {
        super("We could not found a "+clazz.getSimpleName() + " with id: " +number);
    }
}
