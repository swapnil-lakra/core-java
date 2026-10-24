class Parent {
    // overloading candidate
    void show(int a){
        System.out.println("Parent string: "+a);
    }

    void show(String a){
        System.out.println("Parent string: "+a);
    }

    // overriding candidate
    void speak(){
        System.out.println("Parent speaks");
    }
}

class Child extends Parent {
    // overriding
    @Override 
    void speak(){
        System.out.println("Child speaks");
    }

    // overloading
    void show(double a){
        System.out.println("Child double: "+a);
    }
}

public class Main {
    public static void main(String[] args) {
        Parent p1 = new Parent();
        p1.show(10);
        p1.show("HI");

        Child c1 = new Child();
        c1.show(5);
        c1.show(5.5);
        c1.show("Yo");

        Parent pc = new Child();
        pc.speak();
    }
}
