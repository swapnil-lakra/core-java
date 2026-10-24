class Shape {
    Shape copy(){
        System.out.println("Shape.copy()");
        return new Shape();
    }
}

class Circle extends Shape {
    @Override 
    Circle copy(){
        System.out.println("Circle.copy()");
        return new Circle();
    }
}

class BigCircle extends Circle {
    @Override 
    BigCircle copy(){
        System.out.println("BigCircle.copy()");
        return new BigCircle();
    }
}

public class Main {
    public static void main(String[] args) {
        Shape s = new Circle();
        Shape result = s.copy();
        System.out.println("result class: "+result.getClass().getSimpleName());

        Circle c = new Circle();
        Circle result2 = c.copy();
        System.out.println("result class: "+result2.getClass().getSimpleName());
    }    
}
