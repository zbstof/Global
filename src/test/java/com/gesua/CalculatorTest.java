package com.gesua;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Chirp on 11.03.2017.
 */
public class CalculatorTest {

    @Test
    public void arrayEmptyTest(){
        assertTrue("Array should be empty", new ArrayList().isEmpty());
    }

}