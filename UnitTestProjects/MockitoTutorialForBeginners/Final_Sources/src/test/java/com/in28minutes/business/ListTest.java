package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;

/*
Story: Returns go to stock

In order to keep track of stock
As a store owner
I want to add items back to stock when they're returned.

Scenario 1: Refunded items should be returned to stock
Given that a customer previously bought a black sweater from me
And I have three black sweaters in stock.
When he returns the black sweater for a refund
Then I should have four black sweaters in stock.

Scenario 2: Replaced items should be returned to stock
Given that a customer previously bought a blue garment from me
And I have two blue garments in stock
And three black garments in stock.
When he returns the blue garment for a replacement in black
Then I should have three blue garments in stock
And two black garments in stock.
*/

public class ListTest {

	@Test
	public void letsMockListSizeMethod() {
		//Given - setup		
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		//When - actual method call
		
		//Then - asserts
		assertEquals(2,listMock.size());
		assertEquals(2,listMock.size());
		assertEquals(2,listMock.size());
	}

	@Test
	public void letsMockListSize_ReturnMultipleValues() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		
		assertEquals(2,listMock.size());
		assertEquals(3,listMock.size());
	}

	@Test
	public void letsMockListGet() {
		List listMock = mock(List.class);
		//Argument Matcher
		when(listMock.get(anyInt())).thenReturn("in28Minutes");
		
		assertEquals("in28Minutes",listMock.get(0));
		assertEquals("in28Minutes",listMock.get(1));
	}


	@Test
	public void letsMockListGet_usingBDD() {
		//Given
		List<String> listMock = mock(List.class);
		given(listMock.get(anyInt())).willReturn("in28Minutes");
		
		//When
		String firstElement = listMock.get(0);
		
		//Then
		assertThat(firstElement, is("in28Minutes"));
	}

	@Test(expected=RuntimeException.class)
	public void letsMockList_throwAnException() {
		List listMock = mock(List.class);
		//Argument Matcher
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
		
		listMock.get(0);
	}

	@Test(expected=RuntimeException.class)
	public void letsMockList_mixingUp() {
		List listMock = mock(List.class);

		when(listMock.subList(anyInt(), 5)).thenThrow(new RuntimeException("Something"));
		
		listMock.get(0);
	}

}
