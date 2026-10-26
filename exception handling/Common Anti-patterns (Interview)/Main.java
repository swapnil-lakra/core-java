public class Main {

    static void riskyMethod() throws Exception {
        throw new Exception("Risky");
    }
    public static void main(String[] args) {
        // Anti-pattern 1: Empty Catch
        try {
            riskyMethod();
        } catch (Exception e) {
            // silent - debugging impossible 
        }

        // Anti-pattern 2: printStackTree without logging
        try {
            riskyMethod();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Better: log this properly");
        }

        // Anti-pattern 3: Catching too broad
        try {
            riskyMethod();
        } catch (Throwable t) {
            System.out.println("Catching Throwable is bad");
        }

        // Anti-pattern 4: Using exceptions for flow
        try {
            int x = Integer.parseInt("abc");
        } catch(NumberFormatException e) {

        }

        // Anti-pattern 5: Losing Original Exception
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            throw new RuntimeException("Div failed",e);
        }
    }
}
