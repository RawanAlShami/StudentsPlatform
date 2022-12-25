import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent 
{
  student:any;
  constructor(private http: HttpClient, private router: Router){}

  signin()
  {
    let body = 
    {
      "username": (<HTMLInputElement>document.getElementById("usernamein")).value,
      "password": (<HTMLInputElement>document.getElementById("passwordin")).value
    };

    this.http.put('http://localhost:8080/student/signIn', body).subscribe(data => console.log(data));
    sessionStorage.setItem('loggedUsername', body.username);

    this.router.navigateByUrl('/landing');
  }
}