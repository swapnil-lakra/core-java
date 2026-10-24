class Parent {
    static void staticShow(){
        System.out.println("Parent.staticShow()");
    }

    void instanceShow(){
        System.out.println("Parent.instanceShow()");
    }
}

class Child extends Parent {
    static void staticShow(){
        System.out.println("Child.staticShow()");
    }

    @Override 
    void instanceShow(){
        System.out.println("Child.instanceShow()");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent p1 = new Child();
        p1.staticShow();
        p1.instanceShow();

        Child c1 = new Child();
        c1.staticShow();
        c1.instanceShow();

        Parent.staticShow();
        Child.staticShow();

        Parent p2 = new Parent();
        p2.instanceShow();
    }
}
