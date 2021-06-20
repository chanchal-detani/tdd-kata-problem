package com.incubyte.tdd.service.impl;

import com.incubyte.tdd.exception.VerificationFailedException;
import com.incubyte.tdd.service.Verifier;

public class NumberVerifier implements Verifier {

private int minNumbersAllowed = 0;
    
    public NumberVerifier(int minNumbersAllowed) {
        this.minNumbersAllowed = minNumbersAllowed;
    }

    public boolean verify(String password) {
        int noOfDigits = 0;
        char[] passwordCharactersArray = password.toCharArray();
        
        for(char character : passwordCharactersArray){
           if(Character.isDigit(character)){
               noOfDigits++;
           }
        }

        return noOfDigits >= minNumbersAllowed ? true : false;
    }

    @Override
    public void throwException() {
        throw new VerificationFailedException("Password should have at least "+minNumbersAllowed+" number");
    }
}
