import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int marks;

    Student(String name,int marks){
        this.name = name;
        this.marks = marks;
    }

    String getName(){
        return name;
    }

    int getMarks(){
        return marks;
    }

    @Override 
    public int compareTo(Student o){
        return Integer.compare(this.marks, o.marks);
    }

    @Override 
    public String toString(){
        return name + " ("+marks+")";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Amit", 85));
        students.add(new Student("Priya", 95));
        students.add(new Student("Rahul", 78));

        // 1. Comparable - natural order (marks asc)
        System.out.println("---Comparable (natural)---");
        Collections.sort(students); // uses compareTo
        System.out.println(students);

        // 2. Comparator - external logic
        System.out.println("---Comparator (marks desc)---");
        students.sort((a,b) -> Integer.compare(b.marks, a.marks));
        System.out.println(students);

        // 3. Comparator by name
        System.out.println("---Comparator (name asc)---");
        students.sort(Comparator.comparing(s -> s.name));
        System.out.println(students);

        // 4. Chaining comparators
        List<Student> more = new ArrayList<>(Arrays.asList(
            new Student("Zara", 85),
            new Student("Amit", 92),
            new Student("Bob", 85)
        ));

        System.out.println("---Chained mark desc, then name asc---");
        more.sort(Comparator.comparingInt(Student::getMarks).reversed().thenComparing(Student::getName));
        System.out.println(more);

        // 5. Comparator for primitives
        List<Integer> nums = new ArrayList<>(Arrays.asList(5,2,8,1));
        nums.sort(Comparator.naturalOrder());
        System.out.println("Natural Order: "+nums);
        nums.sort(Comparator.reverseOrder());
        System.out.println("Reverse Order: "+nums);

        // 6. String length comparator
        List<String> words = Arrays.asList("Apple","go","banana","hi");
        words.sort(Comparator.comparingInt(String::length));
        System.out.println("by length: "+words);
    }
}
