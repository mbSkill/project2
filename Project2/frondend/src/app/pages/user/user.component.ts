import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit, inject  } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styles: [
  ],
})
export class UserComponent implements OnInit {

  token:string="";
  userData:any = [];

  constructor(private http:HttpClient, private cookieService:CookieService) { }

  ngOnInit(): void {
    this.token= this.cookieService.get("Authorization");
    let header = {
      headers: new HttpHeaders()
        .set('Authorization',  `Bearer ${this.token}`)
    
      } 
    this.http.get("/user", header).subscribe((data) => this.userData= data);
  }

}
