export class User {
    username:string;
    dob:string;
    gender:string;

    constructor(username: string ="",dob: string = "",gender: string = "" ){
        this.username = username;
        this.dob = dob;
        this.gender = gender;
    }
}
