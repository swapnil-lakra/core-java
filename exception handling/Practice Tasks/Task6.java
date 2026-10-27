import java.io.IOException;

public class Task6 {

    static int divide(int a, int b){
        if(b == 0){
            throw new ArithmeticException("Cannot divide by zero");
        }

        return a / b;
    }

    static void readData() throws IOException {
        throw new IOException("Error while reading data");
    }

    public static void main(String[] args) {
        
        try {
            divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Divide Error: "+e.getMessage());
        }

        try {
            readData();
        } catch (IOException e) {
            System.out.println("Read Error: "+e.getMessage());
        }
    }
}
