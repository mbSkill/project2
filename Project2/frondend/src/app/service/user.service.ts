import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../class/user';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  token:string="";
  
  private baseUrl = "http://localhost:8080/user";

  constructor(private httpClient: HttpClient, private cookieService:CookieService) { }

  getUserList(): Observable<User[]>{

    this.token = this.cookieService.get("Authorization");

    let header ={
      headers: new HttpHeaders()
      .set('Authorization',  `Bearer ${this.token}`)
    }
    console.log(header)
    return this.httpClient.get<User[]>(`${this.baseUrl}`,header)
  }
}
