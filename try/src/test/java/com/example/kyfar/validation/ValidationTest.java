package com.example.kyfar.validation;

import com.example.kyfar.exceptions.NullStringDataException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationTest {

    @Test(expected = NullStringDataException.class)
    public void isValidTitleTestNullStringExpectException() {
        Validation.isValidTitle(null);
    }

    @Test
    public void isValidTitleShortStringExpectFalse() {
        assertFalse(Validation.isValidTitle("0"));
    }

    @Test
    public void isValidTitleLongStringExpectFalse() {
        assertFalse(Validation.isValidTitle("123456789012345678901234567890123456789012345678901234567890"));
    }

    @Test
    public void isValidTitleValidStringExpectTrue() {
        assertTrue(Validation.isValidTitle("1234567890123456789012"));
    }

    @Test(expected = NullStringDataException.class)
    public void isValidDescriptionNullStringExpectException() {
        Validation.isValidDescription(null);
    }

    @Test
    public void isValidDescriptionShortStringExpectFalse() {
        assertFalse(Validation.isValidDescription("0"));
    }

    @Test
    public void isValidDescriptionLongStringExpectFalse() {
        assertFalse(Validation.isValidDescription("123456789012345678901234567890123456789012345" +
                "678901234567890123456789012345678901234567890123456789023456"));
    }

    @Test
    public void isValidDescriptionValidStringExpectFalse() {
        assertTrue( Validation.isValidDescription("hello give me smth"));
    }

    @Test(expected = NullStringDataException.class)
    public void isValidPriceNullStringExpectException() {
        Validation.isValidPrice(null);
    }

    @Test
    public void isValidPriceLetterStringExpectFalse() {
        assertFalse(Validation.isValidPrice("asdfgh"));
    }

    @Test
    public void isValidPriceLetterAndNumber1StringExpectFalse() {
        assertFalse(Validation.isValidPrice("asdfgh23"));
    }

    @Test
    public void isValidPriceLetterAndNumber2StringExpectFalse() {
        assertFalse(Validation.isValidPrice("asdfgh23.3"));
    }

    @Test
    public void isValidPriceLetterAndNumberAndNonletter2StringExpectFalse() {
        assertFalse(Validation.isValidPrice("asdfgh23.3///"));
    }

    @Test
    public void isValidPriceNonletter2StringExpectFalse() {
        assertFalse(Validation.isValidPrice("[][[][]/]/]/]"));
    }

    @Test
    public void isValidPriceNumbersStringExpectTrue() {
        assertTrue(Validation.isValidPrice("23456"));
    }

    @Test
    public void isValidPriceNumbersAndOneNumberAfterPointStringExpectFalse() {
        assertFalse(Validation.isValidPrice("23456.0"));
    }

    @Test
    public void isValidPriceNumbersAndJustPointStringExpectFalse() {
        assertFalse(Validation.isValidPrice("23456."));
    }

    @Test
    public void isValidPriceNumbersAndTwoNumbersAfterPointStringExpectTrue() {
        assertTrue(Validation.isValidPrice("23456.12"));
    }

    @Test
    public void isValidPriceNumbersAndThreeNumbersAfterPointStringExpectFalse() {
        assertFalse(Validation.isValidPrice("23456.123"));
    }
}