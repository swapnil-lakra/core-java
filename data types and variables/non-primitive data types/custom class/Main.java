class Student {
    String name;
    int age;

    Student(int age,String name){
        this.age = age;
        this.name = name;
    }

    void introduce(){
        System.out.println("Hi, I am "+name+", age "+age);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(23, "Swapnil");
        Student s2 = new Student(21, "Divyansh");

        s1.introduce();
        s2.introduce();

        // reference behaviour
        Student s3 = s1;
        s3.name = "Yuvraj";

        System.out.println("s1.name after s3 change : "+s1.name);

        // null check
        Student s4 = null;

        if(s4 != null){
            s4.introduce();
        }else{
            System.out.println("s4 is null, skipping");
        }

        // Array of custom objects
        Student[] batch = {
            new Student(21, "Amit"),
            new Student(22, "Rahul")
        };

        for(Student st : batch){
            st.introduce();
        }

    }
}
