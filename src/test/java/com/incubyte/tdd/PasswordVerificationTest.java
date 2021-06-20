package com.incubyte.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.incubyte.tdd.domain.Password;
import com.incubyte.tdd.exception.VerificationFailedException;
import com.incubyte.tdd.service.Verifier;
import com.incubyte.tdd.service.impl.NumberVerifier;

public class PasswordVerificationTest {

    @Test
    public void test_password_length() {
        // positive test case
        // password should be of 8 characters long
        new Password("Password1").validate();
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
    
    @Test public void
    should_fail_if_minimum_conditions_fails() {
        // checking against minimum conditions i.e. 3  are satisfying or not. if not should fail else should pass
        
        Throwable exception = assertThrows(VerificationFailedException.class, () -> {
            new Password("").addFeature(Password.MINIMUM_VALID_CHECKS,3).validate();
        });

        assertEquals("Password is not OK since at least 3 conditions haven't met", exception.getMessage());
    }
    
    @Test public void
    should_fail_if_given_check_fails() {
        // checking against check priority i.e. first given check should get performed before default ones.
        
        Throwable exception = assertThrows(VerificationFailedException.class, () -> {
            List<Verifier> verifiers = new ArrayList<>();
            verifiers.add(new NumberVerifier(2));
            new Password("password")
                .addFeature(Password.REQUIRED_CHECKS, verifiers)
                .validate();
            
        });
        assertEquals("Password should have at least 2 number", exception.getMessage());
        
    }
}
