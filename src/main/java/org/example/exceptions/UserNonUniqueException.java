package org.example.exceptions;

public class UserNonUniqueException extends RuntimeException {

    public UserNonUniqueException(String mssg){
        super(mssg);
    }

}
