import { Component, OnInit } from '@angular/core';
import { TaskService, ModalService } from '../../service'
import {Task} from '../../model'

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  tasks: Task[]

  constructor(private taskService: TaskService, private modalService: ModalService) { }

   ngOnInit() {
  this.getTasks()
  }

  getTasks(){
    this.taskService.getTasks()
    .subscribe(tasks => this.tasks = tasks)
  }

   editTask(task:Task){
        this.modalService.showEditModal(task)
     }

   deleteTask(id: number , index :number){
      this.taskService.deleteTask(id)
      .subscribe(
      () => {this.getTasks()},
      () => {this.tasks.splice(index, 1);}
      )
   }

}
