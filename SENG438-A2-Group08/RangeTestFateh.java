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
    
    
    
    

    // getCentralValue()
    @Test
    void getCentralValue_shouldBeZero_forSymmetricRangeMinus1To1() {
        assertEquals(0.0, exampleRange.getCentralValue(), 1e-9,
                "Central value of -1 to 1 should be 0");
    }

    @Test
    void getCentralValue_shouldBeTwo_forRangeOneToThree() {
        Range r = new Range(1, 3);
        assertEquals(2.0, r.getCentralValue(), 1e-9,
                "Central value of 1 to 3 should be 2");
    }

    @Test
    void getCentralValue_shouldBeMinusFive_forRangeMinus10To0() {
        Range r = new Range(-10, 0);
        assertEquals(-5.0, r.getCentralValue(), 1e-9,
                "Central value of -10 to 0 should be -5");
    }


    
    
    
    
    
    // getUpperBound()
    @Test
    void getUpperBound_shouldBeOne_forRangeMinus1To1() {
        assertEquals(1.0, exampleRange.getUpperBound(), 1e-9,
                "Upper bound of -1 to 1 should be 1");
    }

    @Test
    void getUpperBound_shouldBeThree_forRangeOneToThree() {
        Range r = new Range(1, 3);
        assertEquals(3.0, r.getUpperBound(), 1e-9,
                "Upper bound of 1 to 3 should be 3");
    }


    
    
    
    
    
    // getLowerBound()
    @Test
    void getLowerBound_shouldBeMinusOne_forRangeMinus1To1() {
        assertEquals(-1.0, exampleRange.getLowerBound(), 1e-9,
                "Lower bound of -1 to 1 should be -1");
    }

    @Test
    void getLowerBound_shouldBeOne_forRangeOneToThree() {
        Range r = new Range(1, 3);
        assertEquals(1.0, r.getLowerBound(), 1e-9,
                "Lower bound of 1 to 3 should be 1");
    }


    
    
    
    
    
    // getLength()
    @Test
    void getLength_shouldBeTwo_forRangeMinus1To1() {
        assertEquals(2.0, exampleRange.getLength(), 1e-9,
                "Length of -1 to 1 should be 2");
    }

    @Test
    void getLength_shouldBeZero_forSinglePointRange() {
        Range r = new Range(5, 5);
        assertEquals(0.0, r.getLength(), 1e-9,
                "Length of 5 to 5 should be 0");
    }

    @Test
    void getLength_shouldBeTen_forRangeMinus3To7() {
        Range r = new Range(-3, 7);
        assertEquals(10.0, r.getLength(), 1e-9,
                "Length of -3 to 7 should be 10");
    }

    
    
    
    
    
    // contains()
    @Test
    void contains_shouldReturnTrue_forValueInsideRange() {
        assertTrue(exampleRange.contains(0),
                "Range -1 to 1 should contain 0");
    }

    @Test
    void contains_shouldReturnTrue_forLowerBoundaryValue() {
        assertTrue(exampleRange.contains(-1),
                "Range -1 to 1 should contain -1 (inclusive lower bound)");
    }

    @Test
    void contains_shouldReturnTrue_forUpperBoundaryValue() {
        assertTrue(exampleRange.contains(1),
                "Range -1 to 1 should contain 1 (inclusive upper bound)");
    }

    @Test
    void contains_shouldReturnFalse_forValueBelowRange() {
        assertFalse(exampleRange.contains(-2),
                "Range -1 to 1 should not contain -2");
    }

    @Test
    void contains_shouldReturnFalse_forValueAboveRange() {
        assertFalse(exampleRange.contains(2),
                "Range -1 to 1 should not contain 2");
    }

    @Test
    void contains_shouldReturnFalse_forNaN() {
        assertFalse(exampleRange.contains(Double.NaN),
                "Range should not contain NaN");
    }

    
    
    
    
    

    // intersects()
    @Test
    void intersects_shouldReturnFalse_whenOtherRangeIsCompletelyAbove() {
        assertFalse(exampleRange.intersects(2, 50),
                "Range -1 to 1 should not intersect with 2 to 50");
    }

    @Test
    void intersects_shouldReturnTrue_whenOtherRangeOverlapsOnRight() {
        assertTrue(exampleRange.intersects(0, 50),
                "Range -1 to 1 should intersect with 0 to 50");
    }

    @Test
    void intersects_shouldReturnTrue_whenOtherRangeTouchesUpperBoundary() {
        assertTrue(exampleRange.intersects(1, 50),
                "Range -1 to 1 should intersect with 1 to 50 (touching boundary)");
    }

    @Test
    void intersects_shouldReturnTrue_whenOtherRangeTouchesLowerBoundary() {
        assertTrue(exampleRange.intersects(-10, -1),
                "Range -1 to 1 should intersect with -10 to -1 (touching boundary)");
    }

    @Test
    void intersects_shouldReturnFalse_whenOtherRangeIsCompletelyBelow() {
        assertFalse(exampleRange.intersects(-10, -2),
                "Range -1 to 1 should not intersect with -10 to -2");
    }

    @Test
    void intersects_shouldReturnTrue_whenOtherRangeFullyCoversExampleRange() {
        assertTrue(exampleRange.intersects(-10, 10),
                "Range -1 to 1 should intersect with -10 to 10 (fully covered)");
    }
	
}
