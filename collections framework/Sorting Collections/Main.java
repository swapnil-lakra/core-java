import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Collections.sort on list
        List<String> fruits = new ArrayList<>(Arrays.asList("Banana","Apple","Mango"));
        Collections.sort(fruits);
        System.out.println("Collections.sort: "+fruits);

        // 2. List.sort - Java 8+ (cleaner)
        fruits.sort(Comparator.reverseOrder());
        System.out.println("List.sort(reverse): "+fruits);

        // 3. Arrays.sort on arary
        int[] nums = {5,2,8,1};
        Arrays.sort(nums);
        System.out.println("Arrays.sort: "+Arrays.toString(nums));

        // 4. TreeSet - sorted on insertion
        Set<Integer> sorted = new TreeSet<>(Arrays.asList(5,2,8,1));
        System.out.println("TreeSet: "+sorted);

        // 5. Map sort by key (TreeMap)
        Map<String,Integer> byKey = new TreeMap<>();
        byKey.put("Z", 1);
        byKey.put("A", 2);
        byKey.put("M", 3);
        System.out.println("TreeMap by key: "+byKey);

        // 6. Map sort by value (stream)
        Map<String,Integer> score = new HashMap<>();
        score.put("Amit", 85);
        score.put("Priya", 92);
        score.put("Rahul", 78);

        List<Map.Entry<String,Integer>> entries = new ArrayList<>(score.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        System.out.println("Sort by value desc: ");
        entries.forEach(e -> System.out.println(" "+e.getKey()+" -> "+e.getValue()));

        // 7. Sorting custom objects multiple way
        List<Employee> emps = new ArrayList<>(Arrays.asList(
            new Employee("Amit",30,50000),
            new Employee("Priya",25,60000),
            new Employee("Rahul",35,55000),
            new Employee("Sneha",30,60000)
        ));

        System.out.println("Sort by age, then salary desc, then name");
        emps.sort(Comparator.comparingInt(Employee::getAge)
        .thenComparing(
            Comparator.comparingInt(Employee::getSalary)
            .reversed())
        .thenComparing(Employee::getName));
        emps.forEach(System.out::println);

        // 8. Stream sorted
        System.out.println("Stream sorted (top 2 by salary)");
        emps.stream()
        .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
        .limit(2)
        .forEach(e -> System.out.println(" "+e));
    }
}

class Employee {
    String name;
    int age,salary;
    Employee(String name,int age,int salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public int getSalary(){
        return salary;
    }

    @Override 
    public String toString(){
        return name + " ( age="+age+" ,salary="+salary+" )";
    }
}
