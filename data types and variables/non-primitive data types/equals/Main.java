class Point{
    int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override 
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Point)) return false;
        Point other = (Point) o;
        return this.x == other.x && this.y == other.y;
    }

    @Override 
    public int hashCode(){
        return 31 * x + y;
    }
}

public class Main {
    public static void main(String[] args) {
        String s1 = new String("Java");
        String s2 = new String("Java");

        System.out.println("s1 == s2 : "+(s1 == s2));
        System.out.println("s1.equals(s2) : "+(s1.equals(s2)));

        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);

        System.out.println("p1 == p2 : "+(p1 == p2));
        System.out.println("p1.equals(p2) : "+p1.equals(p2));
    }    
}
