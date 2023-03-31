import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Task } from '../model'

@Injectable({
  providedIn: 'root'
})
export class ModalService {

  constructor() { }

  private task: Task

    private showModalSource = new BehaviorSubject<boolean>(false);
        showCreateModal$ = this.showModalSource.asObservable();

    private showEditModalSource = new BehaviorSubject<boolean>(false);
         showEditModal$ = this.showEditModalSource.asObservable();

    private taskSource = new BehaviorSubject<Task>(this.task);
         task$ = this.taskSource.asObservable();

    showModal() {
      this.showModalSource.next(true);
    }

    hideModal() {
      this.showModalSource.next(false);
    }

    showEditModal(task: Task) {
      this.task = task
      this.taskSource.next(task)

      this.showEditModalSource.next(true);
    }

    hideEditModal() {
      this.showEditModalSource.next(false);
    }

    setTask(task: Task) {
       this.task = task;
    }

    getTask() {
     return this.task;
}


}
