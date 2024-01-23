package com.canwia.security30jwt.exception;

public class ApiRequestException extends RuntimeException{
    public ApiRequestException(String message){
        super(message);
    }
    public ApiRequestException(String message,Throwable cause){
        super(message,cause);
    }
}
