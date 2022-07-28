import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Device } from 'src/app/class/device';
import { DeviceService } from 'src/app/service/device.service';

@Component({
  selector: 'app-add-device',
  templateUrl: './add-device.component.html',
  styles: [
  ]
})
export class AddDeviceComponent implements OnInit {

  device: Device = new Device();

  constructor(private deviceService: DeviceService, private router:Router) { }

  ngOnInit(): void {
  }

  saveDevice(){
    this.deviceService.createDevice(this.device).subscribe( data => {
      console.log(data);
      this.goToDeviceList();
    },
    error => console.log(error));
  }

  goToDeviceList(){
    this.router.navigate(['/user'])
  }

  onSubmit(){
    console.log(this.device);
    this.saveDevice();
  }
}
