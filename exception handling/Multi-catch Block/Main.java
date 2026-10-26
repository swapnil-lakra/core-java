import java.io.IOException;
import java.sql.SQLException;

public class Main {

    static void doWork(int mode) throws IOException,SQLException {
        switch (mode) {
            case 0: throw new IOException("IO Problem");
            case 1: throw new SQLException("DB Problem");
            case 2: throw new IOException("IO Problem");
            case 4: throw new SQLException("DB Problem");
        }
    }

    static void log(Exception e){
        System.out.println(" [log] "+e.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        System.err.println("--- Old Style (repetitive) ---");
        try {
            doWork(0);
        } catch (IOException e) {
            System.out.println("IO: "+e.getMessage());
            log(e);
        } catch (SQLException e) {
            System.out.println("SQL: "+e.getMessage());
            log(e);
        }

        System.out.println("--- Multi-Catch ---");
        try {
            doWork(1);
        } catch (IOException | SQLException e) {
            System.out.println("Caught: "+e.getClass().getSimpleName()+" - "+e.getMessage());
            log(e);
        }

        System.out.println("--- Multi-catch + specific ---");
        try {
            doWork(2);
        } catch (NullPointerException e) {
            System.out.println("NPE: "+e.getMessage());
        } catch (IOException | SQLException e) {
            System.out.println("IO/SQL: "+e.getMessage());
        }

        try {
            doWork(3);
        } catch (IOException | SQLException e) {
            // e = new IOException(); // in multi-catch variable are effictively finaly and cannot be reassign 
            System.out.println("Final: "+e.getMessage());
        }

    }
}
