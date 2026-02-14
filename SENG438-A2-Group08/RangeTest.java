package org.jfree.data.test;

import static org.junit.jupiter.api.Assertions.*;
import org.jfree.data.Range;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RangeTest {
    private Range exampleRange;

    @BeforeEach
    void setUp() {
        exampleRange = new Range(-1, 1);
    }
    //passed
    @Test
    void centralValueShouldBeZero() {
        assertEquals(0.0, exampleRange.getCentralValue(), 1e-9,
                "The central value of -1 and 1 should be 0");
    }
    //Failed
    @Test
    void upperBoundShouldBeOne() {
    	assertEquals(1.0, exampleRange.getUpperBound(), 1e-9,
                "The Upper Bound of -1 and 1 should be 1");
    }
    
    //Passed
    @Test
    void lowerBoundShouldBeMinusOne() {
    	assertEquals(-1.0, exampleRange.getLowerBound(), 1e-9,
                "The lower Bound of -1 and 1 should be -1");
    }
    
    //Passed
    @Test
    void lengthShouldBeTwo() {
    	assertEquals(2.0, exampleRange.getLength(), 1e-9,
                "The lenght of -1 and 1 should be 2");
    }
    
    //Failed
    @Test
    void intersectionShouldBeTrue() {
    	assertTrue(exampleRange.intersects(0,50),
    			"Range -1 to 1 should intersect with 0 to 50");
    }
    
  //passed
    @Test
    void containsShouldBeTrue() {
    	assertTrue(exampleRange.contains(0),
    			"Range -1 to 1 should contain 0");
    }
}