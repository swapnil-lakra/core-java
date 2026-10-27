import java.io.*;

public class Task2 {
    public static void main(String[] args) throws IOException {
        
        try(BufferedReader br = new BufferedReader(new FileReader("hello.txt"));){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch(IOException e){
            System.out.println("Caught: "+e.getMessage());
        }

    }
}
