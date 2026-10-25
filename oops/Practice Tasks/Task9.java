abstract class Shape {
    abstract double area();
    abstract double perimeter();
}

class Circle extends Shape {
    double radi;

    Circle(double radi){
        this.radi = radi; 
    }

    double area(){
        return Math.PI*Math.pow(radi, 2);
    }

    double perimeter(){
        return 2*Math.PI*radi;
    }

    @Override 
    public String toString(){
        return "Circle - area:"+area()+", perimeter:"+perimeter();
    }
}

class Rectangle extends Shape {
    double len, widt;

    Rectangle(double len, double widt){
        this.len = len;
        this.widt = widt;
    }

    double area(){
        return len * widt;
    }

    double perimeter(){
        return 2*(len+ widt);
    }

    @Override 
    public String toString(){
        return "Rectangle - area:"+area()+", perimeter:"+perimeter();
    }
}

class Triangle extends Shape{
    double base ,height;

    Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    double area(){
        return 0.5*base*height;
    }

    double perimeter(){
        return (2*base) * height;
    }

    @Override 
    public String toString(){
        return "Triangle - area:"+area()+", perimeter:"+perimeter();
    }
}

public class Task9 {
    public static void main(String[] args) {
        Shape[] shape = new Shape[]{new Circle(5),new Rectangle(4, 5),
                                    new Triangle(3, 4), new Circle(6), 
                                    new Rectangle(5, 6) };

        double totalArea = 0;

        for(Shape s : shape){
            System.out.println(s);
            totalArea += s.area();
        }

        System.out.println("Total area of 2 Circle, 1 Triangle and 2 Rectangle : "+totalArea);
    }
}
