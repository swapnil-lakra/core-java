import java.io.IOException;
import java.sql.SQLException;

public class Task8 {
    
    static void performOperation(String mode) throws IOException,SQLException {
        if(mode.equals("file")){
            throw new IOException();
        }else if(mode.equals("database")){
            throw new SQLException();
        }else if(mode.equals("runtime")){
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        try {
            performOperation("runtime");
        } catch (IOException | SQLException e) {
            System.out.println("Caught: "+e.getClass().getSimpleName());
        } catch (RuntimeException e) {
            System.out.println("Caught: "+e.getClass().getSimpleName());
        }
    }
}
