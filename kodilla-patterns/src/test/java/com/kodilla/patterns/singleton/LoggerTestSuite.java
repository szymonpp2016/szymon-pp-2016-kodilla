package com.kodilla.patterns.singleton;

import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {

    @BeforeClass
    public static void before() {
        System.out.println(("Starting Logger test \n"));
    }

    @AfterClass
    public static void aftere() {
        System.out.println("\n End Logger test");
    }

    @Test
    public void testGetFileName() {
        //Given
         Logger.getInstance().log("log nr 1");
        //When
        final String lastLog = Logger.getInstance().getLastLog();
        //Then
        assertEquals("log nr 1", lastLog);
    }
}
