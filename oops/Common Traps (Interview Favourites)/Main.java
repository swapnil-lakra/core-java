import java.util.HashSet;
import java.util.Set;

class BadKey {
    int id;
    BadKey(int id){
        this.id = id;
    }

    @Override 
    public boolean equals(Object o){
        return o instanceof BadKey && ((BadKey) o).id == id;
    }
}

public class Main {
    public static void main(String[] args) {
        BadKey k1 = new BadKey(1);
        BadKey k2 = new BadKey(1);
        System.out.println("Trap! equals : "+k1.equals(k2));
        
        Set<BadKey> set = new HashSet<>();
        set.add(k1);
        set.add(k2);
        System.out.println("Trap set size: "+set.size());
    }    
}
