package com.incubyte.tdd.exception;

public class VerificationFailedException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String message;
    public VerificationFailedException() {
        super();
    }
    
    public VerificationFailedException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
}
