package com.company;

public class InvalidAuthenticationException extends Exception{

    public InvalidAuthenticationException(String message) {
        super(message);
    }

    public InvalidAuthenticationException(String message, ErrorCodes errorCodes) {
        super(message + " " + errorCodes);
        System.out.println("Anormal giriş");
    }

    public static enum ErrorCodes{
        LittleException,
        MediumException,
        HardException
    }
}
