enum Color { 
    RED, GREEN, BLUE;

    String getHexCode(Color c){
        switch (c) {
            case RED:
                return "#FF0000";
            case GREEN:
                return "#008000";
            case BLUE:
                return "#0000FF";
            default:
                return "Invalid color";
        }
    }
}

public class Task3 {
    public static void main(String[] args) {
        Color c = Color.BLUE;

        System.out.println("Hex Code of "+c+" color is "+c.getHexCode(c));
    }    
}
