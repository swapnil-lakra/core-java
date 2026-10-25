import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Multiple Catches");
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("NPE caught:"+e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("RTE caught:"+e.getMessage());
        } catch (Exception e) {
            System.out.println("Ex caught:"+e.getMessage());
        }

        // Single Catch
        try {
            String[] arr = new String[2];
            arr[0] = null;
            System.out.println(arr[0].length());
        } catch (NullPointerException e) {
            System.out.println("Caught NPE seperately");
        }
    }
}
