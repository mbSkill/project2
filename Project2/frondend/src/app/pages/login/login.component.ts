import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: [
  ]
})
export class LoginComponent implements OnInit {
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  login(){
    
  }

}
