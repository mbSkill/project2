class Plan {
    id: number;

    name: string;

    price: number;

    deviceLimit: number;

    constructor(id = 0, name = '', price = 0.0, deviceLimit=0){
        this.id = id;
        this.name = name;
        this.price = price;
        this.deviceLimit = deviceLimit; 
      }

}

export default Plan;
