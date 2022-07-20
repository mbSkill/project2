import { animate } from '@angular/animations';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import User from 'src/app/models/user';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  constructor(private httpClient :HttpClient) { }

  users: any;


   getUsers(): Observable<HttpResponse<User>> {
    return this.httpClient.get<User>("/users", {responseType: 'json', observe: 'response'} );
   }

   printUsers() {
    return this.getUsers().subscribe(( response ) =>  { {console.log(response)} } );
   }

}
