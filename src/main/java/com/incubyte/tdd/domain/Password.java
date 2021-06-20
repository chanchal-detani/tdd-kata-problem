package com.incubyte.tdd.domain;

import com.incubyte.tdd.service.Verifier;
import com.incubyte.tdd.service.impl.LengthVerifier;

public class Password {

    private String value;
    private Verifier verifier;
    
    public Password(String value) {
        this.value = value;
        this.verifier = new LengthVerifier(8);
    }

    public String getValue() {
        return value;
    }
    
    public void validate() {
        verifier.verify(this.getValue());
    }
}
