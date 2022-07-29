import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.less'],

})
export class WelcomeComponent implements OnInit {

  myimage: string = 'assets/images/network.png'

  constructor() { }

  ngOnInit(): void {
   
  }

}
