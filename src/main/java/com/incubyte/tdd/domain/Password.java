package com.incubyte.tdd.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.incubyte.tdd.exception.VerificationFailedException;
import com.incubyte.tdd.service.Verifier;
import com.incubyte.tdd.service.impl.BlankVerifier;
import com.incubyte.tdd.service.impl.CaseVerifier;
import com.incubyte.tdd.service.impl.LengthVerifier;
import com.incubyte.tdd.service.impl.NumberVerifier;

public class Password {
    
    public static final String MINIMUM_VALID_CHECKS = "minimumValidChecks";

    private String value;
    private List<Verifier> verifiers = new ArrayList<>();
    private Map<String, Object> miscelleneousFeatures = new HashMap<>();
    
    public Password(String value) {
        this.value = value;
        this.verifiers.add(new BlankVerifier());
        this.verifiers.add(new LengthVerifier(8));
        this.verifiers.add(new CaseVerifier(1, 1));
        this.verifiers.add(new NumberVerifier(1));
    }

    public String getValue() {
        return value;
    }
    
    public Password addFeature(String key, Object value) {
        this.miscelleneousFeatures.put(key, value);
        return this;
    }
    
    public Map<String, Object> getMiscelleneousFeatures() {
        return miscelleneousFeatures;
    }

    public void validate() {
        
        if(this.getMiscelleneousFeatures() != null && !this.getMiscelleneousFeatures().isEmpty()) {
            
            if(this.getMiscelleneousFeatures().containsKey(MINIMUM_VALID_CHECKS)) {
                
                int minimumAllowedVerifiers = Integer.parseInt(this.getMiscelleneousFeatures().get(MINIMUM_VALID_CHECKS).toString());
                int validVerifiers = 0;
                for(Verifier verifier : verifiers) {
                    boolean verify = verifier.verify(this.getValue());
                    if(verify) {
                        validVerifiers++;
                    }
                }
                
                if(validVerifiers <= minimumAllowedVerifiers) {
                    throw new VerificationFailedException("Password is not OK since at least "+minimumAllowedVerifiers+" conditions haven't met");
                }
                
            }
            
        } else {
            Optional<Verifier> verifierOptional = verifiers.stream().filter(verifier -> !verifier.verify(this.getValue())).findAny();
            if(verifierOptional.isPresent()) {
                verifierOptional.get().throwException();
            }
        }
    }
}
