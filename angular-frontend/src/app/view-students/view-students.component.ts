import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-students',
  templateUrl: './view-students.component.html',
  styleUrls: ['./view-students.component.css']
})
export class ViewStudentsComponent implements OnInit{
  students:any;
  constructor(private http: HttpClient) {}

  ngOnInit() 
  {
    let response = this.http.get("http://localhost:8080/students");
    response.subscribe((data) => this.students=data);
  }
}
