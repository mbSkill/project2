import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.less']
})
export class WelcomeComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  header = {
    headers: new HttpHeaders()
      .set('Authorization',  `Bearer ${localStorage.getItem("Authorization")}`)
  } 

  login(){
    this.http.get("/user", this.header)
    .subscribe(data => console.log(data));
  }

}
