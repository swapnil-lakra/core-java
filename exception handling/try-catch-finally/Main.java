
public class Main {
    public static void main(String[] args) {
        // Normal flow: try -> finally
        System.out.println("Case 1 : No exception");
        try {
            System.out.println("Inside Try");
        } finally {
            System.out.println("Inside finally");
        }

        // Exception: try -> catch -> finally
        System.out.println("Case 2: Exception Caught");
        try {
            System.out.println("try: line 1");
            int x = 10 / 0;
            System.out.println("try: line 2 (never runs)");
        } catch (ArithmeticException e) {
            System.out.println("catch: handled");
        } finally {
            System.out.println("finally: always runs");
        }

        // Exception Not Caught
        System.out.println("Case 3: Uncaught exception");
        try {
            try{
                throw new NullPointerException("boom");
            }
            finally{
                System.out.println("finally runs even on uncaught");
            }
        } catch (NullPointerException e) {
            System.out.println("outer catch: "+ e.getMessage());
        }
    }
}
