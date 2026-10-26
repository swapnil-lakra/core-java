import java.io.*;

class MyResources implements AutoCloseable {
    String name;
    
    MyResources(String name){
        this.name = name;
        System.out.println("Opening: "+name);
    }

    void use(){
        System.out.println("Using: "+name);
        if(name.contains("fail")){
            throw new RuntimeException("Failed inside: "+name);
        }
    }

    @Override
    public void close(){
        System.out.println("Closing: "+name);
    }
}

public class Main {
    public static void main(String[] args) {
        // single resource
        System.out.println("--- single resource ---");
        try(MyResources r = new MyResources("A")){
            r.use();
        }
        // close automatically even on exception

        // multiple resource (closes on reverse order)
        System.out.println("--- multiple resources ---");
        try(
            MyResources r1 = new MyResources("R1");
            MyResources r2 = new MyResources("R2");
        ){
            r1.use();
            r2.use();
        }

        //closes even on exceptions
        System.out.println("--- exception handling ---");
        try(MyResources r = new MyResources("fail-resources")) {
            r.use();
        } catch (RuntimeException e) {
            System.out.println("Caught: "+e.getMessage());
        }

        //Real world: file reading
        System.out.println("--- Real World: file reading ---");
        try(BufferedReader br = new BufferedReader(new StringReader("line1\nline2"))) {
            String line;
            while((line = br.readLine()) != null){
                System.out.println("Read: "+line);
            }
        } catch (IOException e) {
            System.out.println("IO Error: "+e.getMessage());
        }

        //java 9+: effectively final vairable;
        MyResources r = new MyResources("XYZ");
        try(r){
            r.use();
        }

        //close(): auto called
    }
}
