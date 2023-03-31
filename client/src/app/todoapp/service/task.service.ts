import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Task} from '../model';


@Injectable({
  providedIn: 'root'
})
export class TaskService {

apiUrl = 'http://localhost:8080';

constructor(private http: HttpClient) { }

  getTasks(){
    return this.http.get<Task[]>(`${this.apiUrl}/task`)
  }

  createTask(task: Task): Observable<Task>{
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<Task>(`${this.apiUrl}/task`, task, { headers });
  }

  deleteTask(id:number): Observable<Task>{
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.delete<Task>(`${this.apiUrl}/task/${id}`, { headers });
  }

  updateTask(task: any, id:number): Observable<Task>{
    return this.http.put<Task>(`${this.apiUrl}/task/${id}`, task, { responseType: 'text' });
  }


}
