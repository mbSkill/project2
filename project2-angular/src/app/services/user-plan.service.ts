import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import UserPlan from "../models/userPlan"

@Injectable({
  providedIn: 'root'
})
export class UserPlanService {

  constructor(private httpClient: HttpClient) {

  }

  findPlansById(id: number) {

  }


}
