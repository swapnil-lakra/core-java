import java.util.*;
import java.util.stream.Collectors;

class Employee implements Comparable<Employee>{
    int id;
    String name,department;
    double salary;

    Employee(int id, String name, String department, double salary){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override 
    public int compareTo(Employee o){
        return Integer.compare(id, o.id);
    }

    @Override 
    public boolean equals(Object o){
        return o != null && 
        o instanceof Employee && 
        ((Employee) o).id == this.id;
    }

    @Override 
    public int hashCode(){
        return 23*id;
    }

    @Override 
    public String toString(){
        return String.format("E%d[%s, %s, %.0f]", id, name, department, salary);
    }
}

public class Main {
    static List<Employee> employees = new ArrayList<>();
    static Map<Integer, Employee> byId = new HashMap<>();
    static Map<String, List<Employee>> byDept = new HashMap<>();
    static Set<String> departments = new TreeSet<>();

    static void addEmployee(Employee e){
        employees.add(e);
        byId.put(e.id, e);
        byDept.computeIfAbsent(e.department,k -> new ArrayList<>()).add(e);
        departments.add(e.department);

    }
    public static void main(String[] args) {
        addEmployee(new Employee(101, "Amit", "Engineering", 80000));
        addEmployee(new Employee(102, "Priya", "Engineering", 90000));
        addEmployee(new Employee(103, "Rahul", "Sales", 60000));
        addEmployee(new Employee(104, "Sneha", "HR", 55000));
        addEmployee(new Employee(105, "Karan", "Sales", 65000));

        System.out.println("--- All Employees (id order) ---");
        Collections.sort(employees);
        employees.forEach(System.out::println);

        System.out.println("--- By ID lookup ---");
        System.out.println("get(103): "+byId.get(103));

        System.out.println("--- Departments (sorted) ---");
        System.out.println(departments);

        System.out.println("---Engineering team---");
        byDept.get("Engineering").forEach(System.out::println);

        System.out.println("--- Sort by salary desc ---");
        employees.stream()
        .sorted(Comparator.comparingDouble((Employee e) -> e.salary).reversed())
        .forEach(System.out::println);

        System.out.println("--- Group by dept ---");
        Map<String,Long> countByDept = employees.stream()
                                       .collect(Collectors.groupingBy(e -> e.department, Collectors.counting()));
        System.out.println(countByDept);

        System.out.println("--- Average Salary by Department");
        Map<String,Double> avgByDept = employees.stream()
                                       .collect(Collectors.groupingBy(e -> e.department,Collectors.averagingDouble(e -> e.salary)));
        avgByDept.forEach((d,avg) -> System.out.printf(" %s: %.0f%n",d,avg));

        System.out.println("--- Highest paid ---");
        employees.stream()
        .max(Comparator.comparingDouble(e -> e.salary))
        .ifPresent(e -> System.out.println(" "+e));
    }    
}
