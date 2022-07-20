import User from "./user";

class Device {
    id: number;
    num: number;
    name: string;
    userId: number;
    user: User;

    constructor(id=0, num=0, name="", userId=0, user = new User){
        this.id= id;
        this.num = num;
        this.name = name;
        this.userId = userId;
        this.user = user;
    }
}

export default Device;