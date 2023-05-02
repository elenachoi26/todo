import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Todo } from '../model/todo';
import { TodoService } from '../todo.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit{
  todo: Todo | undefined;
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
    this.todo = this.todoService.getTodo(this.id);
  }

  gotoModify(): void{
    this.router.navigate(['modify', this.id]);
  }

  goBack(): void{
    this.router.navigate(['']);
  }

}
