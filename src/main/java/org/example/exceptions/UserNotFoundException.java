package org.example.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String mssg){
        super(mssg);
    }
}
