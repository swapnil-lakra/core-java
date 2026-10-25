public class Main {
    static void recursive(){
        recursive();
    }
    public static void main(String[] args) {
        System.out.println("Exception (recoverable)");
        
        // Exception
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught : "+e.getMessage());
        }

        System.out.println("Program continues noramlly");
        
        // Error
        System.out.println("Error (JVM-level)");
        try {
            recursive();
        } catch (StackOverflowError e) {
            System.out.println("StackOverFlowError caught (but you shouldn't)");
        }

        // Throwable
        try {
            throw new Throwable("Custom Throwable");
        } catch (Throwable t) {
            System.out.println("Throwable Catch : "+t.getMessage());
        } 

        // Hierarchy Check
        System.out.println("NPE is Exception?" + (new NullPointerException() instanceof Exception));
        System.out.println("NPE is RumtimeException?" + (new NullPointerException() instanceof RuntimeException));
        System.out.println("SOE is Error?"+(new StackOverflowError() instanceof Error));
    }
}
