import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // list
        List<String> names = new ArrayList<>();
        names.add("Amit");
        names.add("Priya");
        names.add("Amit");

        System.out.println("List : "+names);
        System.out.println("get(1) : "+names.get(1));

        // set 
        Set<String> uniqueNames = new HashSet<>();
        uniqueNames.add("Amit");
        uniqueNames.add("Priya");
        uniqueNames.add("Amit");

        System.out.println("set : "+uniqueNames);
        System.out.println("size : "+uniqueNames.size());

        // map
        Map<Integer,String> idToName = new HashMap<>();
        idToName.put(101, "Amit");
        idToName.put(102, "Priya");
        idToName.put(103, "Amit Kumar");

        System.out.println("map : "+idToName);
        System.out.println("get(101) : "+idToName.get(101));

        //iteration
        System.out.println("Iterate List");
        for(String n : names){
            System.out.println(" - "+n);
        }

        System.out.println("Iterate Set");
        for(String n: uniqueNames){
            System.out.println(" - "+n);
        }

        System.out.println("Iterate Map");
        for(Map.Entry<Integer,String> e : idToName.entrySet()){
            System.out.println(" "+e.getKey()+" -> "+e.getValue());
        }
    }    
}
