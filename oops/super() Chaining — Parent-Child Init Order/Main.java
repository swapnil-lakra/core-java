class Vehicle {
    String type;

    Vehicle(String type){
        this.type = type;
        System.out.println("Vehicle constructor: "+type);
    }   


}

class Bike extends Vehicle {
    String brand;

    Bike(){
        super("Bike");
        System.out.println("Bike no-arg constructor");
    }

    Bike(String brand){
        this();
        this.brand = brand;
        System.out.println("Bike 1-arg constructor: "+brand);
    }

    void display(){
        System.out.println(type + " - " + brand);
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println("--- new Bike(\"Hero\") ---");
        Bike b = new Bike("Hero");
        b.display();
    }
}