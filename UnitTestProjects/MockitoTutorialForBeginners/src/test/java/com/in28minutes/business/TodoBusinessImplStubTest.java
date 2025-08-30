package com.in28minutes.business;

import com.in28minutes.data.stub.TodoService;
import com.in28minutes.data.stub.TodoServiceStub;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoBusinessImplStubTest {

    @Test
    public void usingAStub() {
        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        List<String> todos = todoBusinessImpl
                .retrieveTodosRelatedToSpring("Ranga");
        assertEquals(2, todos.size());
    }

}
