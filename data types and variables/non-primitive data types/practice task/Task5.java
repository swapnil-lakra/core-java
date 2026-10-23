import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        int high = 0;
        List<String> topper = new ArrayList<>();

        Map<String,Integer> students = new HashMap<>();
        students.put("Harshit",55);
        students.put("Aarti",60);
        students.put("Pooja",76);
        students.put("Amit",78);
        students.put("Abhay",78);

        for(Map.Entry<String,Integer> s : students.entrySet()){
            System.out.println(s.getKey()+" "+s.getValue());
            if(high <= s.getValue()){
                if(high != s.getValue()){
                    topper.clear();
                }
                high = s.getValue();
                topper.add(s.getKey());
            }
        }

        System.out.println("Highest marks is "+high+" and topper : "+topper);
    }
}
