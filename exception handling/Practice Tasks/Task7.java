class ResourcesA implements AutoCloseable {

    ResourcesA(){
        System.out.println("This is Resource A Constructor");
    }

    void use(){
        System.out.println("This is Resource A use");
    }
    
    @Override
    public void close() throws Exception {
        System.out.println("This is Resource A close");
    }
}

class ResourcesB implements AutoCloseable {

    ResourcesB(){
        System.out.println("This is Resource B Constructor");
    }

    void use(){
        System.out.println("This is Resource B use");
    }
    
    @Override
    public void close() throws Exception {
        System.out.println("This is Resource B close");
    }
}

public class Task7 {
    public static void main(String[] args) {
        try (
            ResourcesA ra = new ResourcesA();
            ResourcesB rb = new ResourcesB();
        ) {
            ra.use();
            rb.use();
            
        } catch (Exception e) {
            System.out.println("Caught: "+e.getMessage());
        }
    }
}
