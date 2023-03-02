package org.example.exceptions;

public class EmailException extends RuntimeException {

    public EmailException(String mssg){
        super(mssg);
    }
}
