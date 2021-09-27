package com.example.exception;

public class FileOperationException extends Exception{

    public FileOperationException(String errorMessage) {
        super(errorMessage);
    }
}
