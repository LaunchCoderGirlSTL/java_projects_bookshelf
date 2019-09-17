package org.codergirl.java.bookshelf.bookshelf.demos;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnitTestIntro {

    @Test
    public void testDemoAssertStatements(){
        boolean isGarfieldCool = false;

        assertTrue(isGarfieldCool);
        assertEquals(123, 456);
        assertEquals("Hello", "Hallo");
    }
}
