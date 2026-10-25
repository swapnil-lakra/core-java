import java.util.ArrayList;
import java.util.List;

class Department implements Cloneable {
    String name;
    List<String> employee;

    Department(String name,List<String> employee){
        this.name = name;
        this.employee = employee;
    }

    @Override 
    protected Department clone() throws CloneNotSupportedException {
        return (Department) super.clone();
        
    }

    Department deepClone() throws CloneNotSupportedException {
        Department other = (Department) super.clone();
        other.employee = new ArrayList<>(this.employee);
        return other;
    }


}

public class Task10 {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<String> tech = new ArrayList<>();
        tech.add("a");
        tech.add("b");
        tech.add("c");
        tech.add("d");

        List<String> finance = new ArrayList<>();
        finance.add("e");
        finance.add("f");
        finance.add("g");
        finance.add("h");
        
        // Shallow Copy
        Department d1 = new Department("Tech", tech);
        Department d2 = d1.clone();
        d2.employee.remove(3);
        System.out.println("d2.employee.remove(3) : Shallow Copy");
        System.out.println("d1.employee : "+d1.employee);
        System.out.println("d2.employee : "+d2.employee);

        // Deep Copy
        Department d3 = new Department("Finance", finance);
        Department d4 = d3.deepClone();
        d4.employee.remove(3);
        System.out.println("d4.employee.remove(3) : Deep Copy");
        System.out.println("d3.employee : "+d3.employee);
        System.out.println("d4.employee : "+d4.employee);
    }
}
