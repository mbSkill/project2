import { Component, OnInit } from '@angular/core';
import { PlanService } from '../services/planService/plan.service';
import { UserService } from '../services/userService/user.service';

@Component({
  selector: 'app-user-homepage',
  templateUrl: './user-homepage.component.html',
  styleUrls: ['./user-homepage.component.css']
})
export class UserHomepageComponent implements OnInit {

  constructor(private planService: PlanService, private userService: UserService) { }

  ngOnInit(): void {
    this.userService.printUsers();
  }

}
