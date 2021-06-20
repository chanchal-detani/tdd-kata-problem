package com.incubyte.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.incubyte.tdd.domain.Password;
import com.incubyte.tdd.exception.VerificationFailedException;

public class PasswordVerificationTest {

    @Test
    public void test_password_length() {
        // positive test case
        // password should be of 8 characters long
        new Password("Password").validate();
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
    
    @Test public void
    should_throw_exception_for_blank_password() {
     // checking against blank password
        Throwable exception = assertThrows(VerificationFailedException.class, () -> {
            new Password("").validate();
        });

        assertEquals("Password should not be blank.", exception.getMessage());
    }
    
    @Test public void
    should_throw_exception_for_minimum_uppercase_characters() {
     // checking against minimum upper-case characters
        Throwable exception = assertThrows(VerificationFailedException.class, () -> {
            new Password("password").validate();
        });

        assertEquals("Password should have at least 1 uppercase characters and 1 lowercase characters", exception.getMessage());
    }
    
    @Test public void
    should_throw_exception_for_minimum_lowercase_characters() {
     // checking against minimum lower-case characters
        Throwable exception = assertThrows(VerificationFailedException.class, () -> {
            new Password("PASSWORD").validate();
        });

        assertEquals("Password should have at least 1 uppercase characters and 1 lowercase characters", exception.getMessage());
    }
    
    @Test public void
    should_throw_exception_for_minimum_number_allowed() {
     // checking against minimum number/digits allowed
        Throwable exception = assertThrows(VerificationFailedException.class, () -> {
            new Password("Password").validate();
        });

        assertEquals("Password should have at least 1 number", exception.getMessage());
    }
}
