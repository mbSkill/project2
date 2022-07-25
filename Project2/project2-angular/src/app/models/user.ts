class User {
    id: number;
    username: string;
    price: number;
    deviceLimit: number;

    constructor(id=0, name='', price=1, deviceLimit=0){
        this.id = id;
        this.username = name;
        this.price = price;
        this.deviceLimit = deviceLimit;
    }
}

export default User;