package com.incubyte.tdd.service.impl;

import com.incubyte.tdd.exception.VerificationFailedException;
import com.incubyte.tdd.service.Verifier;

public class CaseVerifier implements Verifier {

    int minLowerCaseCharacters = 0;
    int minUpperCaseCharacters = 0;
    
    public CaseVerifier(int minLowerCaseCharacters, int minUpperCaseCharacters) {
        this.minLowerCaseCharacters = minLowerCaseCharacters;
        this.minUpperCaseCharacters = minUpperCaseCharacters;
    }
    
    public int getMinLowerCaseCharacters() {
        return minLowerCaseCharacters;
    }

    public void setMinLowerCaseCharacters(int minLowerCaseCharacters) {
        this.minLowerCaseCharacters = minLowerCaseCharacters;
    }

    public int getMinUpperCaseCharacters() {
        return minUpperCaseCharacters;
    }

    public void setMinUpperCaseCharacters(int minUpperCaseCharacters) {
        this.minUpperCaseCharacters = minUpperCaseCharacters;
    }
    
    public boolean verify(String password) {
        int lowerCaseCharacters = 0;
        int upperCaseCharacters = 0;
        
        char[] passwordCharactersArray = password.toCharArray();
        for(char character : passwordCharactersArray) {
           if(character >='A' && character <='Z') {
               upperCaseCharacters++;
           } else if (character >= 'a' && character <= 'z') {
               lowerCaseCharacters++;
           } else {
              continue;
           }
        }
        
        return lowerCaseCharacters >= minLowerCaseCharacters && upperCaseCharacters >= minUpperCaseCharacters;
    }
    
    @Override
    public void throwException() {
        throw new VerificationFailedException("Password should have at least "+minLowerCaseCharacters+" uppercase characters and "+minUpperCaseCharacters+ " lowercase characters");
    }

    @Override
    public String toString() {
        return "CaseVerifier [minLowerCaseCharacters=" + minLowerCaseCharacters + ", minUpperCaseCharacters=" + minUpperCaseCharacters + "]";
    }

}
