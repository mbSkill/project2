import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit, inject  } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Device } from 'src/app/class/device';
import { DeviceService } from 'src/app/service/device.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styles: [],
})
export class UserComponent implements OnInit {

  token:string="";
  userData:any = [];

  devices: Device[] = [];

  constructor(
    private http:HttpClient, 
    private cookieService:CookieService,
    private deviceService: DeviceService,
    private router:Router, 
     ) { }

  ngOnInit(): void {
    
    this.token= this.cookieService.get("Authorization");
    let header = {
      headers: new HttpHeaders()
        .set('Authorization',  `Bearer ${this.token}`)
    
      } 
    this.http.get("/user", header).subscribe((data) => this.userData= data);
    this.getDevices();
  }

  private getDevices() {
    this.deviceService.getDeviceList().subscribe(data =>{
      this.devices=data;
    })
  }

  updateDevice(id: number){
    console.log(id)
    this.router.navigate(['updatedevice', id]);
  }


  deleteDevice (id:number){
    this.deviceService.deleteDevice(id).subscribe( data => {
      console.log(data);
      this.getDevices();
    })
  } 
}
