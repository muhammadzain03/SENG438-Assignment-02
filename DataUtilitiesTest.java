package org.jfree.data.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jfree.data.Values2D;
import org.junit.jupiter.api.Test;

/**
 * Test class for org.jfree.data.DataUtilities and one Range test.
 * Demo tests: one uses mocking (DataUtilities), one tests Range (no mock).
 */
public class DataUtilitiesTest {

    // ========== MY TEST 1: Uses Mocking (DataUtilities) ==========
    // ECP: valid Values2D table, 2 rows. BVA: nominal column index 0.
    // Tests that calculateColumnTotal sums the values in the given column.
    @Test
    void calculateColumnTotal_TwoRows_ShouldSumValues() {
        // Arrange: mock a 2x1 table so we control the data without a real implementation
        Values2D values = mock(Values2D.class);
        when(values.getRowCount()).thenReturn(2);
        when(values.getValue(0, 0)).thenReturn(7.5);
        when(values.getValue(1, 0)).thenReturn(2.5);

        // Act
        double result = DataUtilities.calculateColumnTotal(values, 0);

        // Assert: 7.5 + 2.5 = 10.0
        assertEquals(10.0, result, 1e-9,
                "Column total for 2 rows (7.5, 2.5) should be 10.0");
    }

    // ========== MY TEST 2: Range test (no mocking) ==========
    // ECP: value inside range. BVA: value at centre of range.
    // Tests that Range.contains() returns true for a value strictly inside the range.
    @Test
    void rangeContains_ValueInsideRange_ReturnsTrue() {
        Range range = new Range(-10, 10);
        assertTrue(range.contains(0),
                "Range (-10, 10) should contain 0 (value inside range)");
    }
}
