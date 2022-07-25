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
  rootApi="/users";

   getUsers(): Observable<HttpResponse<User>> {
    return this.httpClient.get<User>(this.rootApi, {responseType: 'json', observe: 'response'} );
   }

   getUsersByName( name: string): Observable<HttpResponse<User>> {
    return this.httpClient.get<User>(this.rootApi + "/?name=" + name, {responseType: 'json', observe: 'response'});
   }

   printUserByName(name: string){
    return this.getUsersByName(name).subscribe((response) => {console.log(response.body)});
   }

   printUsers() {
    return this.getUsers().subscribe(( response ) =>  { {console.log(response)} } );
   }

}
