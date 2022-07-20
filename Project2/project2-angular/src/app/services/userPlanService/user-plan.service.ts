import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import UserPlan from "../../models/userPlan"

@Injectable({
  providedIn: 'root'
})

export class UserPlanService {

  constructor(private httpClient: HttpClient) {}

  rootApi="/userplan";

  getUserPlansForUser(id: number): Observable<HttpResponse<UserPlan[]>> {
    return this.httpClient.get<UserPlan[]>(this.rootApi +"/?id=" + id,
     {observe: 'response'});
  }

  printUserPlans(id: number){
    return this.getUserPlansForUser(id).subscribe((response) => {console.log(response.body)});
   }


}
