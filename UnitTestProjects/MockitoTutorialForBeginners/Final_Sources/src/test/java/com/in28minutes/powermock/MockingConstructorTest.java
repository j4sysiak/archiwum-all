package com.in28minutes.powermock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemUnderTest.class)
public class MockingConstructorTest {
	
	//PrepareForTest => SystemUnderTest.class
	//override the constuctor
	
	@InjectMocks
	SystemUnderTest systemUnderTest;
	
	@Mock
	ArrayList mockList;

	@Test
	public void testBadNames() throws Exception {

		List<Integer> stats = Arrays.asList(1, 2, 3);
		
		when(mockList.size()).thenReturn(10);
		
		PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);
		
		int size = systemUnderTest.methodUsingAnArrayListConstructor();
		
		assertEquals(10, size);
		
	}
}