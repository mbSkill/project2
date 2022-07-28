import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit, inject  } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { Device } from 'src/app/class/device';
import { User } from 'src/app/class/user';
import { DeviceService } from 'src/app/service/device.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styles: [],
})
export class UserComponent implements OnInit {

  users: User[] =[];
  devices: Device[] = [];

  constructor(
    private userService: UserService,
    private deviceService: DeviceService,
    private router:Router, 
     ) { }

  ngOnInit(): void {
    this.getUser();
    this.getDevices();
  }

  getUser(){
    this.userService.getUserList().subscribe(data => {
      this.users = data;
    })
  }

  getDevices() {
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
