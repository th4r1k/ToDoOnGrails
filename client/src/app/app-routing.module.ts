import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TodoappComponent} from "./todoapp";

const routes: Routes = [
  {path: '', redirectTo: 'todoapp', pathMatch: 'full'},
  {path: 'todoapp', component: TodoappComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
