package com.youbeen.todo.service;

import com.youbeen.todo.data.dao.TodoDAO;
import com.youbeen.todo.data.dto.TodoDto;
import com.youbeen.todo.data.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoSerivce{

    private final TodoDAO todoDAO;
    @Autowired
    public TodoServiceImpl(TodoDAO todoDAO){
        this.todoDAO = todoDAO;
    }
    @Override
    public List<TodoDto> getTodos(){
        List<Todo> todos = todoDAO.selectTodos();
        List<TodoDto> dtoList = new ArrayList<>();

        for(Todo t: todos){
            TodoDto dummy = new TodoDto();
            dummy.setId(t.getId().intValue());
            dummy.setTitle(t.getTitle());
            dummy.setDescription(t.getDescription());

            dtoList.add(dummy);
        }
//        List<TodoDto> dummyList = new ArrayList<TodoDto>();
//
//        dummyList.add(dummy);
//
//        dummy = new TodoDto();
//        dummy.setId(2);
//        dummy.setTitle("Baking");
//        dummy.setDescription("cookie");
//        dummyList.add(dummy);
//
//        dummy = new TodoDto();
//        dummy.setId(3);
//        dummy.setTitle("running");
//        dummy.setDescription("woody's favorite");
//        dummyList.add(dummy);

        //TodoDto[] arr = new TodoDto[todos.size()];
        return dtoList;
    }
    @Override
    public void createTodo(TodoDto todoDto){
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCreatedAt(LocalDateTime.now());
        todo.setUpdatedAt(LocalDateTime.now());
        todoDAO.addTodo(todo);
    }
    @Override
    public void updateTodo(TodoDto todoDto) throws Exception{
        Todo todo = new Todo();
        long id = todoDto.getId();
        todo.setId(id);
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setUpdatedAt(LocalDateTime.now());
        todoDAO.updateTodo(todo);
    }
    @Override
    public void deleteTodo(int Id) throws Exception{
        long id = Id;
        todoDAO.deleteTodo(id);

    }
    @Override
    public TodoDto getTodoById(int Id){
        long id = Id;
        Todo todo = todoDAO.selectTodo(id);
        TodoDto dummy = new TodoDto();
        dummy.setId(Id);
        dummy.setTitle(todo.getTitle());
        dummy.setDescription(todo.getDescription());

        return dummy;
    }
}
