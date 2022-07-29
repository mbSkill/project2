import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { Observable } from 'rxjs';
import { Userplan } from '../class/userplan';

@Injectable({
  providedIn: 'root'
})
export class UserplanService {

  token:string="";
  
  private baseUrl = "http://localhost:8080/user";

  constructor(private httpClient: HttpClient, private cookieService:CookieService) { }

  getUserPlanList(): Observable<Userplan[]>{

    this.token = this.cookieService.get("Authorization");

    let header ={
      headers: new HttpHeaders()
      .set('Authorization',  `Bearer ${this.token}`)
    }
    console.log(header)
    return this.httpClient.get<Userplan[]>(`${this.baseUrl}`,header)
  }

  deleteUserPlan(id: number): Observable<Object>{

    this.token = this.cookieService.get("Authorization");

    let header ={
      headers: new HttpHeaders()
      .set('Authorization',  `Bearer ${this.token}`)
    }

    return this.httpClient.delete(`http://localhost:8080/userplan/delete/${id}`,header);
  }
}
