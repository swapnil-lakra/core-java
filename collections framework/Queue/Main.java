import java.util.*;

class Task implements Comparable<Task> {
        String name;
        int priority;

        Task(String n, int p){
            name = n;
            priority = p;
        }

        @Override 
        public int compareTo(Task o){
            return Integer.compare(this.priority, o.priority);
        }
    }

public class Main {
    public static void main(String[] args) {
        // Priority Queue - min-heap by default
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(50);
        pq.offer(10);
        pq.offer(30);
        pq.offer(20);
        System.out.println("PriorityQueue peek: "+pq.peek());
        System.out.println("PriorityQueue full: "+pq);

        System.out.println("Poll order: ");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll() + " ");
        }
        System.out.println();

        // Priority Queue max-heap
        Queue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
        maxPq.addAll(Arrays.asList(50, 10, 30, 20));
        System.out.println("Max-heap poll: ");
        while (!maxPq.isEmpty()) {
            System.out.println(maxPq.poll()+" ");
        }
        System.out.println();

        // Priority Queue with custom objects
        Queue<Task> tasks = new PriorityQueue<>();
        tasks.offer(new Task("low", 5));
        tasks.offer(new Task("urgent", 1));
        tasks.offer(new Task("medium", 3));
        System.out.println("Task order (by priority):");
        while (!tasks.isEmpty()) {
            Task t = tasks.poll();
            System.out.println(" "+t.name+" (p="+t.priority+")");
        }
        System.out.println();

        // 4. ArrayDequeue as Queue (FIFO)
        Deque<String> queue = new ArrayDeque<>();
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        System.out.println("ArrayDeque (FIFO): ");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll()+" ");
        }
        System.out.println();

        //5. ArrayDeque as Stack (LIFO)
        Deque<String> stack = new ArrayDeque<>();
        stack.push("X");
        stack.push("Y");
        stack.push("Z");
        System.out.println("ArrayDeque (LIFO):");
        while (!stack.isEmpty()) {
            System.out.println(stack.poll() + " ");
        }
        System.out.println();

        //6. Deque as both ends
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerFirst(2);
        dq.offerLast(3);
        dq.offerFirst(1);
        System.out.println("Deque: "+dq);
        System.out.println("peekFirst: "+dq.peekFirst());
        System.out.println("peekLast: "+dq.peekLast());
    }

}
