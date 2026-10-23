enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

enum Priority {
    LOW(1), MEDIUM(2), HIGH(3);

    private final int level;

    Priority(int level){
        this.level = level;
    }

    int getLevel(){
        return level;
    }
}

public class Main {
    public static void main(String[] args) {
        Day today = Day.FRIDAY;
        
        System.out.println("Today : "+today);

        switch (today) {
            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekend!");
                break;
            default:
                System.out.println("Weekday");
        }

        System.out.println("All Days");
        for(Day d: Day.values()){
            System.out.println(" "+d.ordinal()+" -> "+d);
        }

        Day parsed = Day.valueOf("FRIDAY");
        System.out.println("Parsed : "+parsed);

        Priority p = Priority.HIGH;
        System.out.println(p+" level = "+p.getLevel());

        if(p == Priority.HIGH){
            System.out.println(" == works fine for enums");
        }
    }    
}
