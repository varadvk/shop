package com.eclinical.shop.Exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String exceptionMessage) {
        super(exceptionMessage);
    }

}
