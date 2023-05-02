package com.youbeen.todo.service;

import com.youbeen.todo.data.dto.TodoDto;

import java.util.List;

public interface TodoSerivce {
    List<TodoDto> getTodos();
    void createTodo(TodoDto todoDto);
    void updateTodo(TodoDto todoDto) throws Exception;
    void deleteTodo(int Id) throws Exception;
    TodoDto getTodoById(int Id);
}
