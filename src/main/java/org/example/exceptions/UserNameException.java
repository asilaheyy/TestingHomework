package org.example.exceptions;

public class UserNameException extends RuntimeException {

    public UserNameException(String mssg){
        super(mssg);
    }
}
