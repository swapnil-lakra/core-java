import java.io.*;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    //Pattern 1: Checked -> Unchecked wrapping 
    static String readFileContent(String path){
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null){
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to read: "+path, e);
        }
    }

    //Pattern 2: Retry Logic with exceptions
    static void retry(int maxAttempts){
        int attempt = 0;
        while(attempt < maxAttempts){
            try {
                attempt++;
                System.out.println("Attempt "+attempt);
                if(Math.random() < 0.6){
                    throw new IOException("Transient failure");
                }
                System.out.println("Success on attempt: "+attempt);
                return;
            } catch (IOException e) {
                System.out.println(" Failed: "+e.getMessage());
                if(attempt >= maxAttempts){
                    System.out.println(" Giving up after "+maxAttempts);
                    return;
                }

                try {
                    Thread.sleep(200);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Interruped",ie);
                }
            }
        }
    }

    //Pattern 3: try-catch-finally with cleanup
    static void resourceCleanupDemo(){
        InputStream in = null;
        try {
            in = new ByteArrayInputStream("Hello".getBytes());
            System.out.println("Read first byte: "+in.read());
        } catch (IOException e) {
            LOG.warning("IO: "+e.getMessage());
        } finally {
            try {
                if(in != null){
                    in.close();
                }
            } catch (IOException ignored) {
                
            }
        }
    }

    public static void main(String[] args) {
        
        try {
            readFileContent("nofile.txt");
        } catch (UncheckedIOException e) {
            System.out.println("Wrapped: "+e.getMessage()+" | Cause: "+e.getCause().getMessage());
        }

        // Retry
        System.out.println("--- Retry ---");
        retry(3);

        System.out.println("--- Cleanup ---");
        resourceCleanupDemo();
    }
}
