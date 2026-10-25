import java.io.FileReader;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        // Unchecked (which is not checked by compiler because it is rarely happen but it is 100% sure that it is goint to happen)
        System.out.println("--- Unchecked (compiler silent) ---");
        try {
            String s = null;
            s.length();
        } catch (NullPointerException e) {
            System.out.println("NPE caught : "+e.getClass().getSimpleName());
        }

        // Checked (compiler carefully checks all possible exception would occur that is known by compiler)
        System.out.println("--- Checked (compiler forces) ---");
        try {
            FileReader fr = new FileReader("nonexistent.txt");
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFound: "+e.getMessage());
        } catch (Exception e) {
            System.out.println("Other : "+e.getClass().getSimpleName());
        }

        System.out.println("\nChecked -> compiler compels you");
        System.out.println("Unchecked -> compiler trusts you");
    }
}
