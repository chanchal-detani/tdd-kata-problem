package com.incubyte.tdd;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.incubyte.tdd.domain.Password;

public class PasswordVerificationTest {

    @Test public void
    test_password_length() {
        // positive test case
        // password should be of 8 characters long
        new Password("password").validate();
        assertTrue(true);
    }
}
