import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. ArrayList - fast random access O(1) get
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Amit");
        arrayList.add("Priya");
        arrayList.add("Rahul");
        arrayList.add(1,"Sneha");
        System.out.println("ArrayList: "+arrayList);
        System.out.println("get(2): "+arrayList.get(2));
        System.out.println("contains(Priya): "+arrayList.contains("Priya"));
        arrayList.remove("Rahul");
        System.out.println("after remove: "+arrayList);

        // 2. LinkedList - fast add/remove at ends, implements Deque ---
        LinkedList<Integer> linked = new LinkedList<>();
        linked.add(10);
        linked.add(20);
        linked.addFirst(5);
        linked.addLast(30);
        System.out.println("LinkedList: "+linked);
        System.out.println("getFirst: "+linked.getFirst());
        System.out.println("getLast: "+linked.getLast());
        linked.removeFirst();
        System.out.println("after removeFirst: "+linked);

        // 3. Vecor - legacy, synchronized (slow) 
        Vector<String> vec = new Vector<>();
        vec.add("V1");
        vec.add("V2");
        System.out.println("Vector : "+vec);
        System.out.println("capacity : "+vec.capacity());

        // 4. Stack - LIFO (extends Vector)
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack: "+stack);
        System.out.println("peek: "+stack.peek());
        System.out.println("pop: "+stack.pop());
        System.out.println("after pop: "+stack);
        System.out.println("empty? : "+stack.empty());
    }
}
