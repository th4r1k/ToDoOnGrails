import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TableComponent } from './components/table';
import { MenuComponent } from './components/menu';
import { ModalComponent } from './components/modal';
import{ TodoappComponent} from './todoapp.component';
import { TaskService, ModalService } from './service';


@NgModule({
  declarations: [
  TodoappComponent,
  TableComponent,
  MenuComponent,
  ModalComponent
],
  imports: [
    CommonModule,
    FormsModule
  ],
  providers: [
  TaskService,
  ModalService
  ],
  exports: [
  TodoappComponent,
  TableComponent,
  MenuComponent,
  ModalComponent
  ]
})
export class TodoappModule { }
