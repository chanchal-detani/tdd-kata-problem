package com.incubyte.tdd.service.impl;

import com.incubyte.tdd.exception.VerificationFailedException;
import com.incubyte.tdd.service.Verifier;

public class UppercaseVerifier implements Verifier {

    private int minUppercaseCharacters = 1;
    
    public UppercaseVerifier(int minUppercaseCharacters) {
        this.minUppercaseCharacters = minUppercaseCharacters;
    }
    
    public int getMinUppercaseCharacters() {
        return minUppercaseCharacters;
    }

    @Override
    public boolean verify(String password) {
        int upperCaseCharacters = 0;
        
        char[] passwordCharactersArray = password.toCharArray();
        for(char character : passwordCharactersArray) {
           if(character >='A' && character <='Z') {
               upperCaseCharacters++;
           } else {
              continue;
           }
        }
        
        return upperCaseCharacters >= minUppercaseCharacters;

    }

    @Override
    public void throwException() {
           throw new VerificationFailedException("Password should have at least "+minUppercaseCharacters+" uppercase character.");
    }

}
