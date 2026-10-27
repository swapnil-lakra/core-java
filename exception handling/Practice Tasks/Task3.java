

public class Task3 {
    static int excep(){
        try {
            System.exit(0);
        } finally {
            return 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(excep());
    }
}
