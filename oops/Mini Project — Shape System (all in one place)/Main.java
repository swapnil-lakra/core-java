abstract class Shape {
    protected String name;

    Shape(String name){
        this.name = name;
    }

    abstract double area();

    Shape copy(){
        return this; // default - subclass overrides
    }

    @Override 
    public String toString(){
        return name + "[area="+String.format("%.2f", area())+"]";
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius){
        super("Circle");
        this.radius = radius;
    }

    @Override 
    double area(){
        return Math.PI * radius * radius;
    }

    @Override 
    Circle copy(){
        return new Circle(radius); // covariant
    }
}

class Rect extends Shape {
    double w,h;

    Rect(double w, double h){
        super("Rect");
        this.w = w;
        this.h = h;
    }

    @Override 
    double area(){
        return w * h;
    }

    @Override 
    Rect copy(){
        return new Rect(w, h);
    }
}

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Rect(4, 6),
            new Circle(2.5),
            new Rect(3,3)
        };

        System.out.println("--- All Shapes ---");
        for(Shape s : shapes){
            System.out.println(s);
        }

        // --- Total area ---
        double total = 0;
        for(Shape s: shapes){
            total += s.area();
        }
        System.out.printf("Total Area: %2f%n",total);

        // Covariant return (no cast)
        Circle c = new Circle(7);
        Circle clone = c.copy();
        System.out.println("Cloned: "+clone);

        // equals + hashCode on custom class
        Circle c1 = new Circle(5);
        Circle c2 = new Circle(5);
        System.out.println("c1 equals c2 ? : "+c1.equals(c2));

    }
}
