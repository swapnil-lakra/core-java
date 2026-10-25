class Vehicle {
    private String type;

    Vehicle(String type){
        System.out.println("This vehicle is a "+type);
    }
}

class Car extends Vehicle {
    protected String brand;

    Car(String brand){
        super("Car");
        this.brand = brand;
        System.out.println("The brand of this car is "+brand);
    }
}

class ElectricCar extends Car {
    int chargingTime;

    ElectricCar(int ct){
        super("Tesla");
        chargingTime = ct;
        System.out.println(brand+" takes "+chargingTime+" hours to charge fully");
    }
}

public class Task3 {
    public static void main(String[] args) {
        Vehicle v = new ElectricCar(6);
    }  
}
