import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("A","B","C","D"));
        
        // 1. Iterator - forward only, remove supported
        System.out.println("---Iterator---");
        Iterator<String> it = list.iterator();

        while(it.hasNext()){
            String s = it.next();
            System.out.println(" "+s);
            if(s.equals("B")) it.remove();
        }

        System.out.println("After iterator remove: "+list);

        // 2. ListIterator - bidirectional + add/set
        System.out.println("--- ListIterator (forward) ---");
        ListIterator<String> lit = list.listIterator();
        while(lit.hasNext()){
            System.out.println(" next="+lit.next()+", nextIndex="+lit.nextIndex());
        }

        System.out.println("---ListIterator (backwards) ---");
        while(lit.hasPrevious()){
            System.out.println(" next="+lit.previous()+", nextIndex="+lit.previousIndex());
        }

        // 3. ListIterator set() & add()
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3));
        ListIterator<Integer> li = nums.listIterator();

        while(li.hasNext()){
            int x = li.next();
            li.set(x*10);
            if(x == 2) li.add(90);
        }

        System.out.println("ListIterator set+add: "+nums);

        // 4. Enumeration - legacy (for Vector/Stack only)
        System.out.println("---Enumeration (legacy)---");
        Vector<String> vec = new Vector<>(Arrays.asList("X","Y","Z"));
        Enumeration<String> en = vec.elements();
        while(en.hasMoreElements()){
            System.out.println(" "+en.nextElement());
        }

        // 5. forEachRemaining - Java 8+
        System.out.println("---forEachRemaining---");
        Iterator<String> it2 = new ArrayList<>(Arrays.asList("P","Q")).iterator();
        it2.forEachRemaining(s -> System.out.println(" "+s));
    }
}
