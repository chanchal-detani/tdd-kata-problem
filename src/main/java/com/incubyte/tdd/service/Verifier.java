package com.incubyte.tdd.service;

public interface Verifier {
    boolean verify(String password);
    void throwException();
}
