package com.incubyte.tdd.service.impl;

import com.incubyte.tdd.exception.VerificationFailedException;
import com.incubyte.tdd.service.Verifier;

public class BlankVerifier implements Verifier {

    @Override
    public boolean verify(String password) {
        return password != null && password.length() > 0;
    }
    
    @Override
    public void throwException() {
        throw new VerificationFailedException("Password should not be blank.");
    }

}
