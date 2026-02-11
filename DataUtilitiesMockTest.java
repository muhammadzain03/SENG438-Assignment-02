package org.jfree.data.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.jupiter.api.Test;

public class DataUtilitiesMockTest {

	// ------------------------------------
	// calculateColumnTotal (Mockito-based)
	// ------------------------------------

	// Valid column → returns correct sum
	@Test
	public void calculateColumnTotal_validData_validColumn() {
		Values2D mockData = mock(Values2D.class);

		when(mockData.getRowCount()).thenReturn(3);
		when(mockData.getValue(0, 0)).thenReturn(1.0);
		when(mockData.getValue(1, 0)).thenReturn(2.0);
		when(mockData.getValue(2, 0)).thenReturn(3.0);

		double result = DataUtilities.calculateColumnTotal(mockData, 0);

		assertEquals(6.0, result, 0.0000001);
	}

	// Invalid column → returns zero (per Javadoc)
	@Test
	public void calculateColumnTotal_invalidColumn_returnsZero() {
		Values2D mockData = mock(Values2D.class);

		when(mockData.getRowCount()).thenReturn(0);

		double result = DataUtilities.calculateColumnTotal(mockData, 5);

		assertEquals(0.0, result, 0.0000001);
	}

	// Null data → throws NullPointerException (actual implementation behavior)
	@Test
	public void calculateColumnTotal_nullData_throwsNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			DataUtilities.calculateColumnTotal(null, 0);
		});
	}

	// ------------------------------------
	// calculateRowTotal (Mockito-based)
	// ------------------------------------

	// FAILS - Test logic correct --> defect analysis
	// This means calculateRowTotal is not summing the 3 columns like we think.

	// Valid row → returns correct sum
	@Test
	public void calculateRowTotal_validData_validRow() {
		Values2D mockData = mock(Values2D.class);

		when(mockData.getRowCount()).thenReturn(1);
		when(mockData.getColumnCount()).thenReturn(3);

		when(mockData.getValue(0, 0)).thenReturn(1.0);
		when(mockData.getValue(0, 1)).thenReturn(2.0);
		when(mockData.getValue(0, 2)).thenReturn(3.0);

		double result = DataUtilities.calculateRowTotal(mockData, 0);

		assertEquals(6.0, result, 0.0000001);
	}

	// Invalid row → returns zero (per Javadoc)
	@Test
	public void calculateRowTotal_invalidRow_returnsZero() {
		Values2D mockData = mock(Values2D.class);

		when(mockData.getColumnCount()).thenReturn(0);

		double result = DataUtilities.calculateRowTotal(mockData, 5);

		assertEquals(0.0, result, 0.0000001);
	}

	// Null data → throws NullPointerException (actual implementation behavior)
	@Test
	public void calculateRowTotal_nullData_throwsNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			DataUtilities.calculateRowTotal(null, 0);
		});
	}

	// ------------------------------------
	// getCumulativePercentages (Mockito-based)
	// ------------------------------------

	// FAILS - implementation behaves differently --> defect analysis
	// Valid data → returns correct cumulative percentages
	@Test
	public void getCumulativePercentages_validData_returnsCorrectValues() {
		KeyedValues mockData = mock(KeyedValues.class);

		when(mockData.getItemCount()).thenReturn(3);
		when(mockData.getKey(0)).thenReturn("A");
		when(mockData.getKey(1)).thenReturn("B");
		when(mockData.getKey(2)).thenReturn("C");

		when(mockData.getValue(0)).thenReturn(Double.valueOf(5.0));
		when(mockData.getValue(1)).thenReturn(Double.valueOf(9.0));
		when(mockData.getValue(2)).thenReturn(Double.valueOf(2.0));

		KeyedValues result = DataUtilities.getCumulativePercentages(mockData);

		assertEquals(0.3125, result.getValue(0).doubleValue(), 0.0000001);
		assertEquals(0.875, result.getValue(1).doubleValue(), 0.0000001);
		assertEquals(1.0, result.getValue(2).doubleValue(), 0.0000001);
	}

	@Test
	public void getCumulativePercentages_nullData_throwsIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> {
			DataUtilities.getCumulativePercentages(null);
		});
	}
}
