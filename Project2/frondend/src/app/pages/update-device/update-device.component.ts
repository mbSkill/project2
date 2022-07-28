import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Device } from 'src/app/class/device';
import { DeviceService } from 'src/app/service/device.service';

@Component({
  selector: 'app-update-device',
  templateUrl: './update-device.component.html',
  styles: [
  ]
})
export class UpdateDeviceComponent implements OnInit {

  id: number = 0;
  device: Device = new Device();

  constructor(
    private deviceService: DeviceService, 
    private route: ActivatedRoute,
    private router: Router ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params[`id`];

    this.deviceService.getDeviceById(this.id).subscribe(data =>{
      this.device =data;
    }, error => console.log(error))
  }

  onSubmit(){
    this.deviceService.updateDevice(this.id,this.device).subscribe(data => {
      this.goToDeviceList();
    },error => console.log(error))
  }

  goToDeviceList(){
    this.router.navigate([`/user`]);
  }

}
