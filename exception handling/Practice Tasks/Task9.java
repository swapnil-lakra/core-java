

public class Task9 {
    public static void main(String[] args) {
        try {
            System.out.println("Outer resource opened");
            try {
                System.out.println("Inner try started");
                throw new RuntimeException();
            }finally {
                System.out.println("Inner finally executed");
            }
        } catch (RuntimeException e) {
            System.out.println("Outer catch executed: "+e.getMessage());
        } finally {
            System.out.println("Outer finally executed");
        }
    }
}
