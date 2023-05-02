package com.youbeen.todo.controller;

import com.youbeen.todo.data.dto.TodoDto;
import com.youbeen.todo.service.TodoSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/todo")

public class ApiController {
    private final TodoSerivce todoSerivce;

    @Autowired
    public ApiController(TodoSerivce todoSerivce){
        this.todoSerivce=todoSerivce;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<TodoDto>> getTodos(){
        List<TodoDto> todoDtos = todoSerivce.getTodos();
        return ResponseEntity.status(HttpStatus.OK).body(todoDtos);
    }

    @GetMapping(value="{Id}")
    public ResponseEntity<TodoDto> getTodoByID(@PathVariable int Id){
        TodoDto todoDto = todoSerivce.getTodoById(Id);
        return ResponseEntity.status(HttpStatus.OK).body(todoDto);
    }

    @PostMapping()
    public ResponseEntity<String> createTodo(TodoDto tododto){
        todoSerivce.createTodo(tododto);
        return ResponseEntity.status(HttpStatus.OK).body("created");
    }

    @PutMapping()
    public ResponseEntity<String> updateTodo(TodoDto tododto) throws Exception{
        todoSerivce.updateTodo(tododto);
        return ResponseEntity.status(HttpStatus.OK).body("updated");
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteTodo(int Id) throws Exception{
        todoSerivce.deleteTodo(Id);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }
}

