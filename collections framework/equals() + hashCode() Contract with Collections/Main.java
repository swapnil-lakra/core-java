import java.util.*;

class BadKey {
    int id;
    BadKey(int id){
        this.id = id;
    }
    @Override 
    public boolean equals(Object o){
        if(o == null) return false;
        if(!(o instanceof BadKey)) return false;
        return ((BadKey) o).id == this.id; 
    }
}

class GoodKey {
    int id;
    GoodKey(int id){
        this.id = id;
    }
    @Override 
    public boolean equals(Object o){
        return (o != null) && o instanceof GoodKey && ((GoodKey) o).id == this.id;
    }

    @Override 
    public int hashCode(){
        return id;
    }

    @Override 
    public String toString(){
        return "K"+id;
    }
}

public class Main {
    public static void main(String[] args) {
        // 1. BadKey - equals true, but set size wrong
        System.out.println("---BadKey (hashCode missing) ---");
        System.out.println("k1.equals(k2): "+new BadKey(1).equals(new BadKey(1)));

        Set<BadKey> badSet = new HashSet<>();
        badSet.add(new BadKey(1));
        badSet.add(new BadKey(1));
        System.out.println("badSet.size(): "+badSet.size());
        System.out.println("contains(1): "+badSet.contains(new BadKey(1)));

        // 2. GoodKey - hashCode + equals correct 
        System.out.println("--- GoodKey (Proper override) ---");
        Set<GoodKey> goodSet = new HashSet<>();
        goodSet.add(new GoodKey(1));
        goodSet.add(new GoodKey(1));
        goodSet.add(new GoodKey(2));
        System.out.println("goodSet.size(): "+goodSet.size());
        System.out.println("contains(1): "+goodSet.contains(new GoodKey(1)));

        // 3. HashMap with custom key
        System.out.println("Hashmap with custom key");
        Map<GoodKey,String> cmap = new HashMap<>();
        cmap.put(new GoodKey(1), "Apple");
        cmap.put(new GoodKey(2), "Banana");
        System.out.println("get(k1): "+cmap.get(new GoodKey(1)));
        System.out.println("map: "+cmap);

        // 4. HashSet of Strings
        Set<String> strs = new HashSet<>(Arrays.asList("A","A","B"));
        System.out.println("String Set :"+strs);

        // 5. Contract Summary
        System.out.println("\nContract:");
        System.out.println("1. a.equals(a) == true (reflexive)");
        System.out.println("2. a.equals(b) == b.equals(a) (symmetric)");
        System.out.println("3. a.equals(b) && b.equals(c) -> a.equals(c) (transitive)");
        System.out.println("4. a.equals(b) -> a.hashCode() == b.hashCode()");
        System.out.println("5. a.equals(null) == false");
    }
}
