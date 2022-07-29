import { Component, OnInit } from '@angular/core';
import { Plan } from 'src/app/class/plan';
import { Userplan } from 'src/app/class/userplan';
import { PlanService } from 'src/app/service/plan.service';
import { UserplanService } from 'src/app/service/userplan.service';

@Component({
  selector: 'app-plan-list',
  templateUrl: './plan-list.component.html',
  styles: [
  ]
})
export class PlanListComponent implements OnInit {


  plans: Plan[] =[];
  userplans: Userplan[] = [];

  constructor(
    private planService: PlanService,
    private userplanService: UserplanService,
    ) { }

  ngOnInit(): void {
    this.getPlans();
    //this.getUserPlans();
    this.totalPrice();
  }

  private getPlans() {
    this.planService.getPlanList().subscribe(data =>{
      this.plans = data;
    })
  }

  // private getUserPlans() {
  //   this.userplanService.getUserPlanList().subscribe(data =>{
  //     this.userplans = data;
  //   })
  // }

  private totalPrice(){
    console.log(this.plans)
  }

  deleteUserPlan(id:number){
    this.userplanService.deleteUserPlan(id).subscribe( data => {
      console.log(data);
      this.getPlans();
    })
  } 
}
