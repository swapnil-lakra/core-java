class Student{
    String name;
    int age;

    // parameterized constructor
    Student(String name, int age){
        this.name = name;
        this.age = age;
        System.out.println("Parameterized constructor called");
    }

    // copy constructor
    Student(Student other){
        this.name = other.name;
        this.age = other.age;
        System.out.println("Copy constructor called");
    }

    void display(){
        System.out.println(name + " ("+age+")");
    }
}

class StudentRef {
    String name;
    int[] marks;

    StudentRef(String name, int[] marks){
        this.name = name;
        this.marks = marks;
    }

    // Shallow copy 
    StudentRef(StudentRef other){
        this.name = other.name;
        this.marks = other.marks;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Amit",22);
        s1.display();

        // new copy through copy constructor
        Student s2 = new Student(s1);
        s2.display();

        // verify : both are independent
        s2.name = "Amit kumar";
        System.out.println("s1 = "+s1.name);
        System.out.println("s2 = "+s2.name);

        // shallow copy trap (reference share)
        int[] marks1 = {80,90};
        StudentRef r1 = new StudentRef("Priya",marks1);
        StudentRef r2 = new StudentRef(r1);
        
        r2.marks[0] = 100;
        System.out.println("r1.marks[0] = "+r1.marks[0]);
    }
}
