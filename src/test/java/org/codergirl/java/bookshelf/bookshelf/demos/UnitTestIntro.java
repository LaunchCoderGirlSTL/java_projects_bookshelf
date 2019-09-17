package org.codergirl.java.bookshelf.bookshelf.demos;

import org.codergirl.java.bookshelf.demos.Sha256;
import org.codergirl.java.bookshelf.demos.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UnitTestIntro {

    @Test
    public void testDemoAssertStatements(){
        boolean isGarfieldCool = true;

        assertTrue(isGarfieldCool);
        assertEquals(123, 123);
        assertEquals("Hello", "Hello");
    }

    @Test
    public void testUser(){
        User u = new User("janeCoder", "janesPassword",
                "to code all the things!", "jade");

        assertEquals("janeCoder", u.getUserName());
        assertEquals(Sha256.to256("janesPassword"), u.getPassword());
        assertEquals("to code all the things!", u.getQuest());
        assertEquals("jade", u.getFavoriteColor());
    }
}
