package com.div.exceptions;

public class InvalidFileFormat extends Exception{
    private String message;
    public InvalidFileFormat() {
    }

    public InvalidFileFormat(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
