class Parent {
    static void info(){
        System.out.println("Parent cares about his child");
    }

    void display(){
        System.out.println("This is parent");
    }
}

class Child extends Parent {
    static void info(){
        System.out.println("Child depends upon parent for their development and growth");
    }

    @Override 
    void display(){
        System.out.println("This is child");
    }
}

public class Task7 {
    public static void main(String[] args) {
        Parent p = new Child();
        p.info();
        p.display();
    }
}
