package com.shauns.isbntools;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleTests {

    @Test
    public void checkValidTenDigitISBNs(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449116");
        assertTrue("first value", result);
        result = validator.checkISBN("0140177396");
        assertTrue("second value", result);
    }

    @Test
    public void checkValidThirteenDigitISBNs(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9780857684837");
        assertTrue("first value", result);
        result = validator.checkISBN("9781781164556");
        assertTrue("second value", result);
    }

    @Test
    public void tenDigitISBNNumbersEndingInAnXAreValid(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("178116455X");
        assertTrue("first value", result);
    }


    @Test
    public void checkAnInvalidTenDigitISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("0140449117");
        assertFalse(result);
    }

    @Test
    public void checkAnInvalidThirteenDigitISBN(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("9781781164558");
        assertFalse(result);
    }

    @Test(expected = NumberFormatException.class)
    public void nineDigitISBNsNotAllowed(){
        ValidateISBN validator = new ValidateISBN();
        boolean result = validator.checkISBN("123456789");
    }

    @Test(expected = NumberFormatException.class)
    public void nonNumericISBNsAreNotAllowed(){
        ValidateISBN validator = new ValidateISBN();
        validator.checkISBN("helloworld");
    }
}
