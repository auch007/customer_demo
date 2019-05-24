package com.auch.exception;

public class RecordNotFoundException extends RuntimeException {
    
    public RecordNotFoundException(Long id) {
        super("Record id not found : " + id);
    }

}