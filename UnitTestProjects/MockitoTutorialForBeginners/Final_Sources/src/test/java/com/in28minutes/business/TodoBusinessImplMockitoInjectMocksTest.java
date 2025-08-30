package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.in28minutes.data.stub.TodoService;

public class TodoBusinessImplMockitoInjectMocksTest {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	TodoService todoServiceMock;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;

	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
				
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
		
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
				
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		
		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {
		
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		//When 
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		
		//Then	
		assertThat(filteredTodos.size(), is(2));
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD() {
		
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		//When 
		todoBusinessImpl
				.deleteTodosNotRelatedToSpring("Dummy");
		
		//Then
		then(todoServiceMock).should().deleteTodo("Learn to Dance");
		
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring MVC");
		
		then(todoServiceMock).should(never()).deleteTodo("Learn Spring");
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCapture() {
				
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		//When
		todoBusinessImpl
				.deleteTodosNotRelatedToSpring("Dummy");
		
		//Then
		then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
		
		assertThat(stringArgumentCaptor.getValue(),is("Learn to Dance"));
		
	}
	
	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD_argumentCaptureMultipleTimes() {
		
		//Declare Argument Captor
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		
		List<String> todos = Arrays.asList("Learn to Rock and Roll", "Learn Spring",
				"Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		//When
		todoBusinessImpl
				.deleteTodosNotRelatedToSpring("Dummy");
		
		//Then
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		
		assertThat(stringArgumentCaptor.getAllValues().size(),is(2));
	
	}
}
