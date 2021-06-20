package com.incubyte.tdd.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.incubyte.tdd.service.Verifier;
import com.incubyte.tdd.service.impl.BlankVerifier;
import com.incubyte.tdd.service.impl.LengthVerifier;

public class Password {

    private String value;
    private List<Verifier> verifiers = new ArrayList<>();
    
    public Password(String value) {
        this.value = value;
        this.verifiers.add(new BlankVerifier());
        this.verifiers.add(new LengthVerifier(8));
    }

    public String getValue() {
        return value;
    }
    
    public void validate() {
        Optional<Verifier> verifierOptional = verifiers.stream().filter(verifier -> !verifier.verify(this.getValue())).findAny();
        if(verifierOptional.isPresent()) {
            verifierOptional.get().throwException();
        }
    }
}
