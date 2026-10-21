class Main {
    public static void main(String[] args) {
        // Primitive
        int p1 = 10;
        int p2 = p1;
        p2 = 20;
        System.out.println("p1 = "+p1+", p2 = "+p2);

        // Non Primitive
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1;
        arr2[0] = 99;

        System.out.println("arr1[0] = "+arr1[0]);

        // String is also non-primitive
        String s1 = "Hello";
        String s2 = s1;
        s2 = "World";
        System.out.println("s1 = "+s1+", s2 = "+s2);

        // null default
        String name = null;
        // int x = null; // non primitive cannot be null
        System.out.println("name = "+name);
    }
}