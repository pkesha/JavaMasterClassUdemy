package com.parhamkeshavarzi;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {
    private static Utilities utilities;

    @org.junit.Before
    public void setup(){
        utilities = new Utilities();
    }

    @Test
    public void everyNthChar() {
        //fail("This test has not been implemented");
        //Challenge 4
        char test[] = new char[] {'h', 'e', 'l', 'l', 'o'};
        char actual[] = new char[] {'e', 'l'};
        assertArrayEquals(utilities.everyNthChar(test, 2), actual);

        char actual2[] = new char[] {'h', 'e', 'l', 'l', 'o'};
        assertArrayEquals(utilities.everyNthChar(test, 8), actual2);
    }

    @Test
    public void removePairs() {
        //fail("This test has not been implemented");
        //Challenge 2 junit
        assertEquals("ABCDEF", utilities.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", utilities.removePairs("ABCCABDEEF"));

        //Challenge 3 junit
        assertNull("Did not get null returned when argumenet passed was null",
                utilities.removePairs(null));
        assertEquals("A", utilities.removePairs("A"));
        assertEquals("", utilities.removePairs(""));
    }

    @Test
    public void converter() {
        //fail("This test has not been implemented");
        assertEquals(utilities.converter(10, 5), 300);

    }

    @org.junit.Test(expected = ArithmeticException.class)
    public void converter_arithmeticException() throws Exception{
        utilities.converter(10, 0);
    }

    @Test
    public void nullIfOddLength() {
        //fail("This test has not been implemented");
        assertNull(utilities.nullIfOddLength("odd"));
        assertNotNull(utilities.nullIfOddLength("even"));
    }
}