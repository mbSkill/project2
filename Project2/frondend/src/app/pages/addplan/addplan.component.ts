import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Addplan } from 'src/app/class/addplan';
import { PlanService } from 'src/app/service/plan.service';

@Component({
  selector: 'app-addplan',
  templateUrl: './addplan.component.html',
  styleUrls: ['./addplan.component.less']
})
export class AddplanComponent implements OnInit {

  addplan: Addplan = new Addplan();

  constructor(private planService: PlanService, private router: Router) { }

  ngOnInit(): void {

  }

  saveAddPlan(){
    this.planService.creatAddPlan(this.addplan).subscribe(data => {
      console.log(data);
      this.goToPlanList();
    }, error => console.log(error));
  }

  goToPlanList(){
    this.router.navigate(['/userplan'])
  }

  onSubmit(){
    console.log(this.addplan);
    this.saveAddPlan();
  }

}
