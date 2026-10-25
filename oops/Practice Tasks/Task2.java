class Employee {
    String name;
    int id;
    double salary;

    Employee(){
        this("random");
        System.out.println("This is 0-arg Constructor");
    }

    Employee(String name){
        this(name,0);
        System.out.println("This is 1-arg Constructor");
    }

    Employee(String name,int id){
        this(name,id,0.0);
        System.out.println("This is 2-arg Constructor");
    }

    Employee(String name,int id,double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
        System.out.println("This is 3-arg Constructor");
    }
}

public class Task2 {
    public static void main(String[] args) {
        Employee e1 = new Employee();

    }    
}
