import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { Observable } from 'rxjs';
import { Addplan } from '../class/addplan';
import { Plan } from '../class/plan';

@Injectable({
  providedIn: 'root'
})
export class PlanService {

  token:string="";

  private baseUrl = "http://localhost:8080/userplan";

  constructor(private httpClient: HttpClient, private cookieService: CookieService) { }

  getPlanList(id:number=5): Observable<Plan[]>{

    this.token = this.cookieService.get("Authorization");

    let header ={
      headers: new HttpHeaders()
      .set('Authorization',  `Bearer ${this.token}`)
    }
    console.log(header)

    return this.httpClient.get<Plan[]>(`${this.baseUrl}/${id}`, header)
  }

    //create
    creatAddPlan(addplan:Addplan, id:number=5): Observable<Object>{

      this.token = this.cookieService.get("Authorization");
  
      let header ={
        headers: new HttpHeaders()
        .set('Authorization',  `Bearer ${this.token}`)
      }
  
      return this.httpClient.post(`http://localhost:8080/userplan/${id}`, addplan, header)
    }

}
