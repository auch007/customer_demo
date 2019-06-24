package com.auch.exception;

public class RecordNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 4161876298929286134L;

    public RecordNotFoundException(Long id) {
        super("Record id not found : " + id);
    }

}