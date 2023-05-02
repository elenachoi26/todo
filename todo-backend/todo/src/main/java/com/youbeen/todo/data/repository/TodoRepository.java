package com.youbeen.todo.data.repository;

import com.youbeen.todo.data.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
