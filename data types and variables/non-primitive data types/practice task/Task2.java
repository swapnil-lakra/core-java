

public class Task2 {
    public static void main(String[] args) {
        String name = "Madam";
        StringBuilder reverseName = new StringBuilder(name).reverse();
        
        System.out.println(name.toLowerCase().equals(reverseName.toString().toLowerCase()));
    }
}
