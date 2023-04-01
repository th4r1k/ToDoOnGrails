import { Component, OnInit, ViewChild, HostListener} from '@angular/core';
import { ModalService, TaskService } from '../../service'
import { Task } from '../../model'
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent implements OnInit {

  @ViewChild('createForm', {static: true}) createForm: NgForm;
  @ViewChild('editForm', {static: false}) editForm: NgForm;

  showCreateModal$ = this.modalService.showCreateModal$;
  showEditModal$ = this.modalService.showEditModal$;

  task$ = this.modalService.task$;
  task:Task

  constructor(private modalService: ModalService, private taskService: TaskService) {
  }

  ngOnInit() {
    this.modalService.task$.subscribe((task)=> this.task = task)
  }

  createTask(createForm: NgForm){
    this.taskService.createTask(createForm.value).subscribe(
    response => {createForm.reset()},
    error => {console.log(error)},
    () => this.hideCreateModal())
    }

    hideCreateModal(){
        this.modalService.hideModal()
        }

  updateTask(editForm: NgForm){
  this.taskService.updateTask(editForm.value, this.task.id).subscribe(
  response => {console.log(response)},
  error => {console.log(error)},
  ()=> this.hideEditModal())
  }

  hideEditModal(){
    this.modalService.hideEditModal()
    }

  @HostListener('document:keydown.escape', ['$event'])
  onEscapeKeydown(event: KeyboardEvent) {
      this.hideCreateModal()
      this.hideEditModal()
  }

}
