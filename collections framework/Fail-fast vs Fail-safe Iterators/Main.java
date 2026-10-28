import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        
        // 1. Fail-fast - ConcurrentModificationException
        System.out.println("---Fail-fast (ArrayList)---");
        List<String> list = new ArrayList<>(Arrays.asList("A","B","C"));

        try {
            for(String s : list){
                if(s.equals("B")) list.add("D");
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("CME Caught: "+e.getClass().getSimpleName());
        }

        // 2. Fail-fast with iterator.remove() - SAFE
        System.out.println("--- Safe remove via iterator ---");
        List<String> list2 = new ArrayList<>(Arrays.asList("A","B","C"));
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            if(it.next().equals("B")) it.remove();
        }
        System.out.println("After safe remove: "+list2);
        
        // 3. Fail-fast removeIf - Java 8+
        System.out.println("---removeIf---");
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        nums.removeIf(n -> n%2 == 0);
        System.out.println("After removeIf: "+nums);

        // 4. Fail-safe - CopyOnWriteArrayList
        System.out.println("---Fail-safe (CopyOnWriteArrayList)---");
        List<String> safe = new CopyOnWriteArrayList<>(Arrays.asList("X","Y","Z"));
        for(String s: safe){
            if(s.equals("Y")) safe.add("W");
        }
        System.out.println("After safe modify: "+safe);

        // 5. Fail-safe - ConcurrentHashMap
        System.out.println("---Fail-safe (ConcurrentHashMap)---");
        Map<String,Integer> chm = new ConcurrentHashMap<>();
        chm.put("A", 1);
        chm.put("B", 2);
        chm.put("C", 3);
        for(Map.Entry<String,Integer> e: chm.entrySet()){
            if(e.getKey().equals("B")) chm.put("D", 4);
        }
        System.out.println("ConcurrentHashMap: "+chm);

        // 6. Iterator removes wrong pattern
        System.out.println("---Iterator removes gotcha---");
        List<String> l3 = new ArrayList<>(Arrays.asList("A","B"));
        Iterator<String> it3 = l3.iterator();
        it3.next();
        it3.remove();
        try {
            it3.remove();
        } catch (IllegalStateException e) {
            System.out.println("Second remove: "+e.getClass().getSimpleName());
        }
    }
}
