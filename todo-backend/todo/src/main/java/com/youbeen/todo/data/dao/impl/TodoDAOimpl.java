package com.youbeen.todo.data.dao.impl;

import com.youbeen.todo.data.dao.TodoDAO;
import com.youbeen.todo.data.entity.Todo;
import com.youbeen.todo.data.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TodoDAOimpl implements TodoDAO {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoDAOimpl(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo addTodo(Todo todo){
        Todo savedTodo = todoRepository.save(todo);
        return savedTodo;

    }
    @Override
    public Todo selectTodo(Long id){
        Todo selectTodo = todoRepository.getById(id);
        return selectTodo;
    }
    @Override
    public Todo updateTodo(Todo todo) throws Exception {
        Optional<Todo> selectTodo = todoRepository.findById(todo.getId());
        Todo updatedTodo;
        if(selectTodo.isPresent()){
            Todo updatingTodo =selectTodo.get();
            updatingTodo.setTitle(todo.getTitle());
            updatingTodo.setDescription(todo.getDescription());

            updatedTodo = todoRepository.save(updatingTodo);
        }else{
            throw new Exception();
        }
        return updatedTodo;
    }
    @Override
    public void deleteTodo(Long id) throws Exception{
        Optional<Todo> selectTodo = todoRepository.findById(id);
        if(selectTodo.isPresent()){
            Todo deletingtodo = selectTodo.get();
            todoRepository.delete(deletingtodo);
        }else{
            throw new Exception();
        }
    }

    @Override
    public List<Todo> selectTodos(){
        List<Todo> todos = todoRepository.findAll();
        return todos;
    }

}
