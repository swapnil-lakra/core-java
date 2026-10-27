public class Task1 {
    public static void main(String[] args) {
        int[] arr = new int[3];
        try {
            arr[5] = 10;

        } catch (NullPointerException e) {
            System.out.println("Caught: "+e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Caught: "+e.getMessage());
        } catch ( ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: "+e.getMessage());
        } catch (Exception e ){
            System.out.println("Caught: "+e.getMessage());
        }
    }
}
