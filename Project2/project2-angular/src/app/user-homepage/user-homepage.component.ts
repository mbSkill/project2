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
plans: any = [];
  ngOnInit(): void {
    this.plans = this.userPlanService.getUserPlansForUser(5)
    .subscribe((response) => response.body?.entries);
  }

  



}
