import java.io.IOException;
import java.sql.SQLException;

public class Main {

    static void readFile() throws IOException {
        throw new IOException("File not available");
    }

    static void checkAge(int age){
        if(age < 18){
            throw new IllegalArgumentException("Age must be >= 18, got "+age);
        }
        System.out.println("Eligible: "+age);
    }

    static void multi() throws IOException,SQLException {
        if(Math.random() > 0.5) throw new IOException("IO issue");
        else throw new SQLException("DB issue");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(" throw (unchecked) ");
        try {
            checkAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught : "+e.getMessage());
        }

        System.out.println(" throws (checked) ");
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("Caught : "+e.getMessage());
        }

        System.out.println("multiple throws");
        try {
            multi();
        } catch (IOException | SQLException e) {
            System.out.println("Multi : "+e.getClass().getSimpleName());
        }
        
        Thread.sleep(100);
        System.out.println("\nDone");
    }
}
