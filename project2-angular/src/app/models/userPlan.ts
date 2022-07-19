class UserPlan {
    id: number;


    userId: number;

    planId: number;

    deviceId: number;

    constructor(id = 0, userId=0, planId=0, deviceId=0){
        this.id = id;
        this.userId = userId;
        this.planId = planId;
        this.deviceId = deviceId;
      }

}

export default UserPlan;
