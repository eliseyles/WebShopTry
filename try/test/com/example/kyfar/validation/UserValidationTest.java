package com.example.kyfar.validation;

import com.example.kyfar.exceptions.NullStringDataException;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserValidationTest {

    @Test(expected = NullStringDataException.class)
    public void isValidUsernameTestNullExpect() {
        UserValidation.isValidUsername(null);
    }

    @Test
    public void isValidUsernameTestShortStringExpectFalse() {
        assertFalse(UserValidation.isValidUsername("0"));
    }

    @Test
    public void isValidUsernameTestLongStringExpectFalse() {
        assertFalse(UserValidation.isValidUsername("23456789012345678901234567890"));
    }

    @Test
    public void isValidUsernameTestInvalidRegexStringExpectFalse() {
        assertFalse(UserValidation.isValidUsername("/////"));
    }

    @Test
    public void isValidUsernameTestValidStringExpectTrue() {
        assertTrue(UserValidation.isValidUsername("elisey1"));
    }

    @Test(expected = NullStringDataException.class)
    public void isValidPasswordTestNullPasswordExpectException() {
        UserValidation.isValidPassword(null);
    }

    @Test
    public void isValidPasswordTestShortPasswordExpectFalse() {
        UserValidation.isValidPassword("123");
    }

    @Test
    public void isValidPasswordTestLongPasswordExpectFalse() {
        UserValidation.isValidPassword("123456789012345678901234567890123456789");
    }

    @Test
    public void isValidPasswordTestValidPasswordExpectTrue() {
        UserValidation.isValidPassword("123456789012345678901234567890123456789");
    }


}