package com.div.exceptions;

public class InvalidFlag extends Exception{
    private String message;

    public InvalidFlag() {
    }

    InvalidFlag(String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
