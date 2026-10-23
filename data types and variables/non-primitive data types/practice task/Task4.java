import java.util.Set;
import java.util.HashSet;

class Student {
    private String name;
    private int rollNo;

    Student(String name, int rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }

    @Override 
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Student)) return false;
        Student other = (Student) o;
        return this.name == other.name && this.rollNo == other.rollNo;
    }

    @Override 
    public int hashCode(){
        return 32 * rollNo;
    }
}

public class Task4 {
    public static void main(String[] args) {
        Student s = new Student("Swapnil", 101);
        Set<Student> students = new HashSet<>();
        students.add(s);
        students.add(s);

        System.out.println("Size of students : "+students.size());
    }
}
