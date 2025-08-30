package com.in28minutes.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.in28minutes.data.stub.TodoService;
import com.in28minutes.data.stub.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAStub() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(
				todoServiceStub);
		List<String> filteredTodos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}

}
