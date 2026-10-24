class Car {
    String brand, model;
    int year;

    Car(String brand){
        this(brand,"Unknown");
        System.out.println("1-arg constructor");
    }

    Car(String brand, String model){
        this(brand,model,2024);
        System.out.println("2-arg constructor");
    }

    Car(String brand, String model,int year){  
        this.brand = brand;
        this.model = model;
        this.year = year;
        System.out.println("3-arg constructor (Final)");
    }

    void display(){
        System.out.println(brand + " " + model + " " + year);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Creating Car(\"Tata\") ---");
        Car c1 = new Car("Tata");
        c1.display();

        System.out.println("\n--- Creating Car(\"Tata\", \"Nexon\") ---");
        Car c2 = new Car("Tata","Nexon");
        c2.display();
    }
}
