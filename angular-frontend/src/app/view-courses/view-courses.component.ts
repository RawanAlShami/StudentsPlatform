import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-view-courses',
  templateUrl: './view-courses.component.html',
  styleUrls: ['./view-courses.component.css']
})
export class ViewCoursesComponent implements OnInit
{
  courses:any;
  student:any;

  constructor(private http: HttpClient) {}

  ngOnInit() 
  {
    let response = this.http.get("http://localhost:8080/courses");
    response.subscribe((data) => this.courses=data);
  }

  enrollInCourse(data: any): void
  {
    let loggedUsername=sessionStorage.getItem('loggedUsername');
  
    this.http.get("http://localhost:8080/student/"+loggedUsername).toPromise().then(data=>{
      this.student=data;
    });

    let getBody = JSON.parse(JSON.stringify(this.student));

    let studentID = getBody["studentID"];

    let body={};

    this.http.put('http://localhost:8080/' + data.courseID + '/students/' + studentID, body).subscribe(data => console.log(data));

    alert("Successfully Enrolled")
  }
}