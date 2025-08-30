package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.in28minutes.data.stub.TodoService;

public class TodoBusinessImplMockTest {
	// What is mocking?
	// mocking is creating objects that simulate the behavior of real objects.
	// Unlike stubs, mocks can be dynamically created from code - at runtime.
	// Mocks offer more functionality than stubbing.
	// You can verify method calls and a lot of other things.

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAMock() {
				
		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
		
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(
				todoServiceMock);
				
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		
		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(
				todoServiceMock);

		//When 
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		
		//Then	
		assertThat(filteredTodos.size(), is(2));
	}

	@Test
	public void testDeleteTodosNotRelatedToSpring_usingBDD() {
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(
				todoServiceMock);

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
		
		//Declare Argument Captor
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(
				todoServiceMock);

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
		
		//Given
		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList("Learn to Rock and Roll", "Learn Spring",
				"Learn to Dance");
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(
				todoServiceMock);

		//When
		todoBusinessImpl
				.deleteTodosNotRelatedToSpring("Dummy");
		
		//Then
		then(todoServiceMock).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		
		assertThat(stringArgumentCaptor.getAllValues().size(),is(2));
		
	}

}
