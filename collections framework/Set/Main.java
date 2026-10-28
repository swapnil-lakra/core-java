import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. HashSet - unordered, fast O(1)
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Banana");
        hashSet.add("Apple");
        hashSet.add("Cherry");
        hashSet.add("Apple");

        System.out.println("HashSet: "+hashSet);
        System.out.println("size: "+hashSet.size());

        // 2. LinkedHashSet - insertion order preserve
        Set<String> linkedSet = new LinkedHashSet<>();
        linkedSet.add("Banana");
        linkedSet.add("Apple");
        linkedSet.add("Cherry");
        linkedSet.add("Apple");
        System.out.println("LinkedHashSet: "+linkedSet);

        // 3. TreeSet - sorted (natural order ya comparator)
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(50);
        treeSet.add(10);
        treeSet.add(30);
        treeSet.add(20);
        System.out.println("TreeSet: "+treeSet);

        // TreeSet Navigation methods
        TreeSet<Integer> t = new TreeSet<>(Arrays.asList(10,20,30,40,50));
        System.out.println("first: "+t.first());
        System.out.println("last: "+t.last());
        System.out.println("higher(30): "+t.higher(30));
        System.out.println("lower(30): "+t.lower(30));
        System.out.println("headSet(30): "+t.headSet(30));
        System.out.println("tailSet(30): "+t.tailSet(30));

        // TreeSet Custom Comparator (desc)
        Set<Integer> descSet = new TreeSet<>(Comparator.reverseOrder());
        descSet.addAll(Arrays.asList(3,1,2));
        System.out.println("Desc TreeSet: "+descSet);

        // Behaviour of null with TreeSet
        Set<String> withNull = new HashSet<>();
        withNull.add(null);
        System.out.println("HashSet with null: "+withNull);
    }
}
