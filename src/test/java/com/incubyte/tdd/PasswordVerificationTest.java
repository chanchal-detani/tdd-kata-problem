package com.incubyte.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.incubyte.tdd.domain.Password;

public class PasswordVerificationTest {

    @Test
    public void test_password_length() {
        // positive test case
        // password should be of 8 characters long
        new Password("password").validate();
        assertTrue(true);
    }

    @Test
    public void should_throw_required_exception_for_minimum_length() {
        
        // checking minimum length of the password
        Throwable exception = assertThrows(VerificationFailedException.class, () -> {
            new Password("pwd").validate();
        });

        assertEquals("Password should be at least 8 characters long.", exception.getMessage());

    }
}
