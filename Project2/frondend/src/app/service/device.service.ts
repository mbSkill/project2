import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { Observable } from 'rxjs';
import { Device } from '../class/device';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  token:string="";
  
  private baseUrl = "http://localhost:8080/user/device";

  constructor(private httpClient: HttpClient, private cookieService:CookieService) { }

  //get 
  getDeviceList(): Observable<Device[]>{

    this.token = this.cookieService.get("Authorization");

    let header ={
      headers: new HttpHeaders()
      .set('Authorization',  `Bearer ${this.token}`)
    }
    //console.log(header)

    return this.httpClient.get<Device[]>(`${this.baseUrl}`,header)
  }

  //create
  createDevice(device:Device): Observable<Object>{

    this.token = this.cookieService.get("Authorization");

    let header ={
      headers: new HttpHeaders()
      .set('Authorization',  `Bearer ${this.token}`)
    }

    return this.httpClient.post(`http://localhost:8080/device`, device, header)
  }

  getDeviceById(id: number): Observable<Device>{

    this.token = this.cookieService.get("Authorization");

    let header ={
      headers: new HttpHeaders()
      .set('Authorization',  `Bearer ${this.token}`)
    }

    return this.httpClient.get<Device>(`http://localhost:8080/device/${id}`,header);
  }

  updateDevice(id: number, device: Device) : Observable<Object>{

    this.token = this.cookieService.get("Authorization");

    let header ={
      headers: new HttpHeaders()
      .set('Authorization',  `Bearer ${this.token}`)
    }

    return this.httpClient.put(`http://localhost:8080/device/${id}`,device, header);
  }

  deleteDevice(id: number): Observable<Object>{

    this.token = this.cookieService.get("Authorization");

    let header ={
      headers: new HttpHeaders()
      .set('Authorization',  `Bearer ${this.token}`)
    }

    return this.httpClient.delete(`http://localhost:8080/device/${id}`,header);
  }

}
