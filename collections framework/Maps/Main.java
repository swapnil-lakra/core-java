import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        // 1. HashMap - unorderd fast
        Map<String,Integer> hashMap = new HashMap<>();
        hashMap.put("Apple", 50);
        hashMap.put("Banana", 20);
        hashMap.put("Cherry", 80);
        hashMap.put("Apple", 60);
        System.out.println("HashMap: "+hashMap);
        System.out.println("get(Apple): "+hashMap.get("Apple"));
        System.out.println("containsKey: "+hashMap.containsKey("Banana"));
        System.out.println("getOrDefault: "+hashMap.getOrDefault("Grape", 0));

        // 2. LinkedHashMap - insertion order
        Map<String, Integer> linked = new LinkedHashMap<>();
        linked.put("Zebra", 1);
        linked.put("Apple", 2);
        linked.put("Mango", 3);
        System.out.println("LinkedHashMap: "+linked);

        // 3. TreeMap - Sorted by key
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Zebra", 1);
        treeMap.put("Apple", 2);
        treeMap.put("Mango", 3);
        System.out.println("TreeMap: "+treeMap);
        System.out.println("firstKey: "+((TreeMap<String,Integer>)treeMap).firstKey());
        System.out.println("lastKey: "+((TreeMap<String,Integer>)treeMap).lastKey());

        // 4. HashTable - legacy, synchronized, null NOT allowed
        Hashtable<String,Integer> ht = new Hashtable<>();
        ht.put("X", 1);
        ht.put("Y", 2);
        System.out.println("Hashtable: "+ht);
        try {
            ht.put("Z", null);
        } catch (NullPointerException e) {
            System.out.println("Hashtable null -> NPE");
        }

        // 5. Concurrent Hashmap - thread safe, modern
        ConcurrentHashMap<String,Integer> chm = new ConcurrentHashMap<>();
        chm.put("A", 1);
        chm.put("B", 2);
        chm.putIfAbsent("A", 9);
        System.out.println("ConcurrentHashMap: "+chm);
        System.out.println("getOrDefault: "+chm.getOrDefault("Z", 0));

        // 6. Iteration Styles
        Map<String, Integer> m = new HashMap<>();
        m.put("a", 1);
        m.put("b", 2);
        m.put("c", 3);

        System.out.println("--- KeySet ---");
        for(String k : m.keySet()){
            System.out.println(k+" ");
        }
        System.out.println();

        System.out.println("--- values ---");
        for(Integer v : m.values()){
            System.out.println(v+" ");
        }
        System.out.println();

        System.out.println("--- entrySet ---");
        for(Map.Entry<String,Integer> e : m.entrySet()){
            System.out.println(" "+e.getKey()+" -> "+e.getValue());
        }

        System.out.println("--- forEach ---");
        m.forEach((k,v) -> System.out.println(" "+k+"="+v));
    }    
}
