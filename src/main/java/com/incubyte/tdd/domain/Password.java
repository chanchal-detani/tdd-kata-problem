package com.incubyte.tdd.domain;

public class Password {

    private String value;
    
    public Password(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public void validate() {
        throw new UnsupportedOperationException();
    }
}
