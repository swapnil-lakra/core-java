import java.util.Arrays;

class Print {

    void show(int x){
        System.out.println("The age of employee is "+x);
    }

    void show(double d){
        System.out.println("The salary of employee is "+d);
    }

    void show(String s){
        System.out.println("Employee name : "+s);
    }

    void show(int[] i){
        System.out.println("Attendence of employee");
        for(int att: i){
            System.out.print(att+" ");
        }
        System.out.println();
    }

    void show(Object o){
        if(o == null){
            System.out.println("Object is null");
        }

        if(!(o instanceof Employee)){
            System.out.println("Invalid Object");
        }

        Employee emp = (Employee) o;

        System.out.println(emp.name+" is "+emp.age+" and he earns rs. "+emp.salary+" and his attendance is "+Arrays.toString(emp.attendance));
    }
}

class Employee {
    String name;
    int age;
    double salary;
    int[] attendance;

    Employee(){
        this.name = "Swapnil";
        this.age = 23;
        this.salary = 80000.0;
        this.attendance = new int[]{1,1,1,1,0};
    }
}

public class Task4 {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Print print = new Print();

        print.show(e1.age);
        print.show(e1.salary);
        print.show(e1.name);
        print.show(e1.attendance);
        print.show(e1);
    }
}
