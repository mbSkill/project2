import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import Plan from '../../models/plan';

@Injectable({
  providedIn: 'root'
})
export class PlanService {

  url = "/plans";

  constructor(private httpClient: HttpClient) {

  }

  findAllPlans(): Observable<Plan[]>{
    return this.httpClient.get<Plan[]>(this.url);
  }

  findAllByIds(ids: Array<number>) {

  }

}
