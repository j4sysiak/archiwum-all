package com.in28minutes.data.stub;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
	// Dynamic Condition
	// Service Definition

	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance");
	}

	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}

}
