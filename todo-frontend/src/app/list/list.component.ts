import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Todo } from '../model/todo';
import { TodoService } from '../todo.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  todos: Todo[] = [];

  constructor(private todoService:TodoService,
    private router: Router,
    private route: ActivatedRoute){}
  
  ngOnInit():void{
    this.getTodos();
  }

  getTodos(){
    this.todoService.getTodos().subscribe(todos => this.todos = todos);
  }

  gotoDetail(): void{
    this.router.navigate(['detail', 0]);
  }

  deleteTodo(id: number): void{
    this.todoService.deleteTodos(id);
  }

  createTodo(): void{
    this.router.navigate(['modify', 0]);
  }
}
