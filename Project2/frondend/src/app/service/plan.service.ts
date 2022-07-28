import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { Observable } from 'rxjs';
import { Plan } from '../class/plan';

@Injectable({
  providedIn: 'root'
})
export class PlanService {

  token:string="";
  private baseUrl = "http://localhost:8080/plan";

  constructor(private httpClient: HttpClient, private cookieService: CookieService) { }

  getDeviceList(): Observable<Plan[]>{

    this.token = this.cookieService.get("Authorization");

    let header ={
      headers: new HttpHeaders()
      .set('Authorization',  `Bearer ${this.token}`)
    }
    console.log(header)

    return this.httpClient.get<Plan[]>(`${this.baseUrl}`, header)
  }
}
