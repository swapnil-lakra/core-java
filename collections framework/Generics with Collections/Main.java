import java.util.*;

class Box<T> {
    private T item;
    void setItem(T item){
        this.item = item;
    }
    T getItem(){
        return item;
    }
}

class NumberBox<T extends Number>{
    private T num;
    NumberBox(T n){
        this.num = n;
    }
    double doubleValue(){
        return num.doubleValue();
    }
}

public class Main {
    static double sumAll(List<? extends Number> list){
        double s = 0;
        for(Number n: list){
            s += n.doubleValue();
        }
        return s;
    }

    static void addInts(List<? super Integer> list){
        list.add(1);
        list.add(2);
    }

    static <T> void printAll(List<T> list){
        for(T t: list){
            System.out.println(t + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        // 1. type safe collection
        List<String> strs = new ArrayList<>();
        strs.add("Amit");
        System.out.println("strings: "+strs);

        // 2. Diamond operator
        List<Integer> nums = new ArrayList<>(); 
        nums.add(10);
        nums.add(20);
        System.out.println("integers: "+nums);
        
        // 3. Generic Class
        Box<String> sBox = new Box<>();
        sBox.setItem("Hello");
        System.out.println("Box<String>: "+sBox.getItem());

        Box<Integer> iBox = new Box<>();
        iBox.setItem(100);
        System.out.println("Box<Integer>: "+iBox.getItem());

        // 4. Bounded Generic
        NumberBox<Integer> nb = new NumberBox<>(20);
        System.out.println("Bounded: "+nb.doubleValue());

        // 5. WildCards extends (read)
        List<Integer> ints = Arrays.asList(1,2,3);
        List<Double> dbls = Arrays.asList(1.5,2.5);
        System.out.println("sumAll(ints): "+sumAll(ints));
        System.out.println("sumALl(dbls): "+sumAll(dbls));

        // 6. Wildcard super (write)
        List<Number> numbers = new ArrayList<>();
        addInts(numbers);
        System.out.println("Wildcard super: "+numbers);

        // 7. Generic Method
        printAll(Arrays.asList("x","y","z"));
        printAll(Arrays.asList(1,2,5));

        // 8. Type erasure trap
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();

        System.out.println("Erasure check: "+a.getClass().equals(b.getClass()));

        // 9. Generics with Map
        Map<String, List<Integer>> multiMap = new HashMap<>();
        multiMap.computeIfAbsent("scores", k -> new ArrayList<>()).add(80);
        multiMap.computeIfAbsent("scores", k -> new ArrayList<>()).add(85);

        System.out.println("multiMap: "+multiMap);
    }
}
