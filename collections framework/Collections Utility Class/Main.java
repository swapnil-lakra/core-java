import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(5,2,8,1,9,3));
        System.out.println("Original : "+list);

        // 1. sort / reverse
        Collections.sort(list);
        System.out.println("sort: "+list);
        Collections.reverse(list);
        System.out.println("reverse: "+list);

        // 2. min / max
        System.out.println("min: "+Collections.min(list));
        System.out.println("max: "+Collections.max(list));

        // 3. Shuffle
        Collections.shuffle(list);
        System.out.println("shuffle: "+list);

        // 4. Swap
        Collections.swap(list, 0, 5);
        System.out.println("swap: "+list);

        // 5. frequency / disjoint
        List<Integer> dup = Arrays.asList(1,2,2,3,2,4);
        System.out.println("Frequency(2) : "+Collections.frequency(dup,2));
        System.out.println("disjoint : "+Collections.disjoint(Arrays.asList(1,2), Arrays.asList(3,4)));

        // 6. fill / replace and rotate
        List<String> names = new ArrayList<>(Arrays.asList("a","b","c","d"));
        Collections.rotate(names, 2);
        System.out.println("rotate(2): "+names);
        Collections.replaceAll(names, "a", "X");
        System.out.println("replaceAll(a,X): "+names);

        // 7. UnmodifiableList - read-only
        List<String> readOnly = Collections.unmodifiableList(names);
        System.out.println("unmodifiable: "+readOnly);
        try {
            readOnly.add("E");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify readonly list");
        }

        // 8. Singleton / empty
        System.out.println("singleton: "+Collections.singleton("Only"));
        System.out.println("emptyList: "+Collections.emptyList());

        // 9. Binary Search (Sorted List - Important)
        List<Integer> sorted = new ArrayList<>(Arrays.asList(10,20,30,40,50));
        int idx = Collections.binarySearch(sorted, 30);
        System.out.println("BinarySearch: index of 30 = "+idx);

        // 10. nCopies
        System.out.println("nCopies : "+Collections.nCopies(3, "hi"));
    }
}
