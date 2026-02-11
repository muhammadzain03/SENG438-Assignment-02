package org.jfree.data.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.jupiter.api.Test;

public class DataUtilitiesMockTest {

	// ------------------------------------
	// calculateColumnTotal (Mockito-based)
	// ------------------------------------

	// Passed
	@Test
	public void calculateColumnTotal_validData_validColumn() {
		// Arrange
		Values2D mockData = mock(Values2D.class);

		when(mockData.getRowCount()).thenReturn(3);
		when(mockData.getValue(0, 0)).thenReturn(1.0);
		when(mockData.getValue(1, 0)).thenReturn(2.0);
		when(mockData.getValue(2, 0)).thenReturn(3.0);

		// Act
		double result = DataUtilities.calculateColumnTotal(mockData, 0);

		// Assert
		assertEquals(6.0, result, 0.0000001);
	}

	// Failed
	@Test
	public void calculateColumnTotal_invalidColumn_returnsZero() {
		// Arrange
	    Values2D mockData = mock(Values2D.class);
		
		when(mockData.getRowCount()).thenReturn(0);

		// Act
		double result = DataUtilities.calculateColumnTotal(mockData, 5);

		// Assert
		assertEquals(0.0, result, 0.0000001);
	}

	// Failed
	@Test
	public void calculateColumnTotal_nullData_throwsNullPointerException() {
	    assertThrows(NullPointerException.class, () -> {
	        DataUtilities.calculateColumnTotal(null, 0);
	    });
	}

	// ------------------------------------
	// calculateRowTotal (Mockito-based)
	// ------------------------------------

	// Failed
	@Test
	public void calculateRowTotal_validData_validRow() {
		// Arrange
		Values2D mockData = mock(Values2D.class);

		// Row 0 has 3 columns
		when(mockData.getColumnCount()).thenReturn(3);
		when(mockData.getValue(0, 0)).thenReturn(1.0);
		when(mockData.getValue(0, 1)).thenReturn(2.0);
		when(mockData.getValue(0, 2)).thenReturn(3.0);

		// Act
		double result = DataUtilities.calculateRowTotal(mockData, 0);

		// Assert
		assertEquals(6.0, result, 0.0000001);
	}

	@Test
	public void calculateColumnTotal_invalidColumn_returnsZero() {
		// Arrange
	    Values2D mockData = mock(Values2D.class);

		// There are 2 columns
		when(mockData.getColumnCount()).thenReturn(2);

		// Act
		double result = DataUtilities.calculateRowTotal(mockData, 5);

		// Assert
		assertEquals(0.0, result, 0.0000001);
	}

	// Failed
	@Test
	public void calculateRowTotal_nullData_throwsNullPointerException() {
	    assertThrows(NullPointerException.class, () -> {
	        DataUtilities.calculateRowTotal(null, 0);
	    });
	}

	// ------------------------------------
	// getCumulativePercentages (Mockito-based)
	// ------------------------------------

	@Test
	public void getCumulativePercentages_validData_returnsCorrectValues() {
		// Arrange
		KeyedValues mockData = mock(KeyedValues.class);

		when(mockData.getItemCount()).thenReturn(3);
		when(mockData.getKey(0)).thenReturn("A");
		when(mockData.getKey(1)).thenReturn("B");
		when(mockData.getKey(2)).thenReturn("C");

		when(mockData.getValue(0)).thenReturn(5.0);
		when(mockData.getValue(1)).thenReturn(9.0);
		when(mockData.getValue(2)).thenReturn(2.0);

		// Act
		KeyedValues result = DataUtilities.getCumulativePercentages(mockData);

		// Assert
		assertEquals(0.3125, result.getValue(0).doubleValue(), 0.0000001);
		assertEquals(0.875, result.getValue(1).doubleValue(), 0.0000001);
		assertEquals(1.0, result.getValue(2).doubleValue(), 0.0000001);
	}

	@Test
	public void getCumulativePercentages_nullData_throwsNullPointerException() {
	    assertThrows(NullPointerException.class, () -> {
	        DataUtilities.getCumulativePercentages(null);
	    });
	}


}