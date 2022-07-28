import { Component, OnInit } from '@angular/core';
import { Plan } from 'src/app/class/plan';
import { PlanService } from 'src/app/service/plan.service';

@Component({
  selector: 'app-plan-list',
  templateUrl: './plan-list.component.html',
  styles: [
  ]
})
export class PlanListComponent implements OnInit {


  plans: Plan[] =[];

  constructor(private planService: PlanService) { }

  ngOnInit(): void {
    this.getPlans();
  }

  private getPlans() {
    this.planService.getDeviceList().subscribe(data =>{
      this.plans = data;
    })
  }

}
