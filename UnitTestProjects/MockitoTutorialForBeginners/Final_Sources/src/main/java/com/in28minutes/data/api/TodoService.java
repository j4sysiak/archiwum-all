package com.in28minutes.data.stub;

import java.util.List;

//Create TodoServiceStub
//Test TodoBusinessImpl using TodoServiceStub
public interface TodoService {
	public List<String> retrieveTodos(String user);

	public void deleteTodo(String todo);
}
