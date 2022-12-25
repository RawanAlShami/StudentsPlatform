import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})

export class SignupComponent 
{
  constructor(private http: HttpClient, private router: Router){}

  signup()
  {
    let options = { headers: new HttpHeaders().set('Content-Type', 'application/json') };

    let body = 
    {
      "username": (<HTMLInputElement>document.getElementById("username")).value,
      "password": (<HTMLInputElement>document.getElementById("password")).value
    };

    if(body.password==(<HTMLInputElement>document.getElementById("repeatPassword")).value)
    {
      let response = this.http.post("http://localhost:8080/student/register", body).subscribe(data => console.log(data));

      alert("Account Created Successfully")
      this.router.navigateByUrl('/signin');
    }
    else
    {
      alert("Passwords Do Not Match")
    }
  }
}