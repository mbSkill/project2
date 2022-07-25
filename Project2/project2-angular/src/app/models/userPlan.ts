import Device from "./device";
import Plan from "./plan";
import User from "./user";

class UserPlan {
    id: number;
    userId: number;
    planId: number;
    deviceId: number;
    device: Device;
    plan: Plan;
    user: User;


    constructor(id = 0, userId=0, planId=0, deviceId=0,
       device=new Device, plan =new Plan, user= new User){
        this.id = id;
        this.userId = userId;
        this.planId = planId;
        this.deviceId = deviceId;
        this.device = device;
        this.plan = plan;
        this.user = user;
      }

}

export default UserPlan;
