import { Component, OnInit } from '@angular/core';
import UserPlan from '../models/userPlan';
import { PlanService } from '../services/planService/plan.service';
import { UserPlanService } from '../services/userPlanService/user-plan.service';
import { UserService } from '../services/userService/user.service';

@Component({
  selector: 'app-user-homepage',
  templateUrl: './user-homepage.component.html',
  styleUrls: ['./user-homepage.component.css']
})
export class UserHomepageComponent implements OnInit {

  constructor(private userPlanService: UserPlanService) { }
  userPlans: Array<UserPlan> = new Array;


  ngOnInit(): void {
     this.userPlanService.getUserPlansForUser(8)
    .subscribe((response) =>  {this.userPlans = response.body || new Array} );
  }

  handle(){
    console.log(this.userPlans);
  }
  



}
