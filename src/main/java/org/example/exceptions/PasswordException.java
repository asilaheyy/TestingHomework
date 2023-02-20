package org.example.exceptions;

public class PasswordException extends RuntimeException {

    public PasswordException(String mssg){
        super(mssg);
    }
}
