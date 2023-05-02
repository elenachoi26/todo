import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { TODOS } from './mock-todo';
import { Todo } from './model/todo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  private baseUrl = 'http://localhost:8080/api/todo'

  constructor(private http: HttpClient) { }

  todos: Todo[] = TODOS;

  getTodos(): Observable<Todo[]> {
    return this.http.get<Todo[]>(this.baseUrl + '/all');
  }

  addTodos(todo: Todo){
    // todo:: id가 0인 
    this.todos.push(todo);
  }

  updateTodos(todo: Todo){
    let found = this.todos.find(e => e.id === todo.id);
    if(found){
      found = todo;
    }
  }

  deleteTodos(todoID: number){
    let found = this.todos.findIndex(e => e.id === todoID);
    this.todos.splice(found, 1); 
  }

  getTodo(id: number){
    const todo=TODOS.find(t=> t.id === id)!;
    return todo;
  }
}
