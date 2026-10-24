class Employee{
    String name;
    int id;

    Employee(String name, int id){
        this.name = name;
        this.id = id;
    }

    @Override 
    public String toString(){
        return "Employee(name='"+name+"', id="+id+"}";
    }

    @Override 
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Employee other = (Employee) o;
        return this.id == other.id && this.name.equals(other.name); 
    }

    @Override 
    public int hashCode(){
        return 31 * id + name.hashCode();
    }
    
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Amit", 101);
        Employee e2 = new Employee("Amit", 101);
        Employee e3 = new Employee("Priya", 102);

        // toString()
        System.out.println("e1 : "+e1);
        System.out.println("e2 : "+e2);

        // equals()
        System.out.println("e1 == e2 : "+(e1 == e2));
        System.out.println("e1.equals(e2) : "+e1.equals(e2));
        System.out.println("e1.equals(e3) : "+e1.equals(e3));

        // hashCode()
        System.out.println("e1.hashCode() : "+e1.hashCode());
        System.out.println("e2.hashCode() : "+e2.hashCode());
        System.out.println("Same ? "+(e1.hashCode() == e2.hashCode()));

        // HashSet behaviour 
        java.util.Set<Employee> employeeSet = new java.util.HashSet<>();
        employeeSet.add(e1);
        employeeSet.add(e2); // equals+hashCode match -> duplicate
        employeeSet.add(e3);

        System.out.println("employeeSet size: "+employeeSet.size());
        System.out.println("Set : "+employeeSet);
    }
}
