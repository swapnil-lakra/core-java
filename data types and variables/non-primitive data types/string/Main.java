public class Main {
    public static void main(String[] args) {
        // literal vs new
        String a = "Java";
        String b = "Java";
        String c = new String("Java");

        System.out.println("a == b : "+ (a==b));
        System.out.println("a == c : "+(a==c));

        System.out.println("a.equals(c) : "+a.equals(c));

        String s = "Hello";
        s.concat(" World");
        System.out.println("s after concat : "+s);

        s = s.concat(" World");
        System.out.println("s reassigned : "+s);

        // Common string methods
        String text = "  Java Programming  ";
        System.out.println("length : ["+text.length()+"]");
        System.out.println("trim : "+text.trim());
        System.out.println("toUpperCase : "+text.toUpperCase());
        System.out.println("contains : "+text.contains("Java"));
        System.out.println("charAt(2) : "+text.trim().charAt(2));
        System.out.println("substring : "+text.trim().substring(5));
        System.out.println("split : "+text.trim().split(" ").length + " words");
        
        // --- StringBuilder - mutuable 
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= 5; i++){
            sb.append(i).append(" ");
        }
        System.out.println("StringBuilder : "+sb.toString().trim());
    }
}
