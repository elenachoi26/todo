package com.youbeen.todo.data.dao;

import com.youbeen.todo.data.entity.Todo;

import java.util.List;

public interface TodoDAO {
    Todo addTodo(Todo todo);
    Todo selectTodo(Long id);
    Todo updateTodo(Todo todo) throws Exception;

    void deleteTodo(Long id) throws Exception;
    List<Todo> selectTodos();

}
