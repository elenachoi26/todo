import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Todo } from '../model/todo';
import { TodoService } from '../todo.service';

@Component({
  selector: 'app-modify',
  templateUrl: './modify.component.html',
  styleUrls: ['./modify.component.css']
})
export class ModifyComponent implements OnInit{
  
  todo: Todo = {
    id: 0,
    title: '',
    description: ''
  };

  //@Input() todo?: Todo;
  id: number | undefined;

  constructor(
    private route: ActivatedRoute,
    private todoService: TodoService,
    private router: Router
  ){}

  ngOnInit():void{
    this.getTodo();
  }

  getTodo(): void{
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    if(this.id !== 0){
      this.todo = this.todoService.getTodo(this.id);
    }
  }

  goBack(): void{
    if(this.todo.id === 0){
      //create할 때
      this.todoService.addTodos(this.todo);
    }
    else{
      //update mode
      this.todoService.updateTodos(this.todo);
    }
    this.router.navigate(['detail', this.id]);
  }
}
