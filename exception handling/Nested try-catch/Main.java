import javax.management.RuntimeErrorException;

public class Main {
    public static void main(String[] args) {
        // Basic nested - inner handle, outer unaffected
        System.out.println("Nested (inner handles)");
        try {
            System.out.println("Outer try start");
            try {
                int[] a = new int[2];
                a[5] = 10;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner Caught: "+e.getMessage());
            }
            System.out.println("Outer try continues");
        } catch (Exception e) {
            System.out.println("Outer caught");
        }

        // Inner doesn't get affted , outer does
        System.out.println("Nested (inner fails -> outer)");
        try {
            try {
                int x = 10 / 0;
            } catch (NullPointerException e) {
                System.out.println("Inner won't run");
            }
        } catch (ArithmeticException e) {
            System.out.println("Outer caught: "+e.getMessage());
        }

        // Finally ke saath
        System.out.println("Nested with finally");
        try {
            try {
                throw new RuntimeException("inner");
            } finally {
                System.out.println("inner finally");
            }
        } catch (RuntimeException e) {
            System.out.println("Outer caugth: "+e.getMessage());
        } finally {
            System.out.println("Outer finally");
        }
    }
}
