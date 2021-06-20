package com.incubyte.tdd.service.impl;

import com.incubyte.tdd.exception.VerificationFailedException;
import com.incubyte.tdd.service.Verifier;

public class LengthVerifier implements Verifier {

    private int minLength = 0;

    public LengthVerifier(int minLength) {
        this.minLength = minLength;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public boolean verify(String password) {

        return password.length() >= minLength;
        
    }
    
    @Override
    public String toString() {
        return "LengthVerifier [minLength=" + minLength + "]";
    }

    @Override
    public void throwException() {
        throw new VerificationFailedException("Password should be at least "+minLength+" characters long.");
        
    }

}
