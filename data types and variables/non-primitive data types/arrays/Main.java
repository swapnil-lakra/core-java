import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Declaration
        int[] a = new int[3];
        int[] b = {10, 20, 30};
        int[] c = new int[]{5, 6, 7};

        System.out.println("a = "+Arrays.toString(a));
        System.out.println("b = "+Arrays.toString(b));
        System.out.println("b = "+Arrays.toString(c));

        // Access & Update
        b[1] = 99;
        System.out.println("After update : "+Arrays.toString(b));
        System.out.println("Length : "+b.length);

        // Common Operator
        int[] nums = {5, 2, 8, 1, 9};
        Arrays.sort(nums);
        System.out.println("Sorted : "+Arrays.toString(nums));

        int idx = Arrays.binarySearch(nums, 8);
        System.out.println("8 found at : "+idx);

        // 2D Array
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };

        for(int[] row : matrix){
            System.out.println("Row : "+Arrays.toString(row));
        }

        // Array of objects
        String[] names = {"Amit","Priya","Rahul"};
        
        for(String n: names){
            System.out.println("Name : "+n.toUpperCase());
        }
    }    
}
