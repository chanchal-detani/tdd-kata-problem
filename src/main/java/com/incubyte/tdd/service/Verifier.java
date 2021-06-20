package com.incubyte.tdd.service;

@FunctionalInterface
public interface Verifier {
    boolean verify(String password);
}
