class InvalidPasswordException extends Exception {
    private int attemptLeft;
    public InvalidPasswordException(int attempLeft,String cause){
        super(cause);
        this.attemptLeft = attempLeft;
    }

    int getAttemptLeft(){
        return attemptLeft;
    }

}

class LoginSystem {
    String password = "Swapnil";
    int attempLeft = 3;

    void login(String password){
        try {
            if(attempLeft > 0){
                if(!this.password.equals(password)){
                    attempLeft--;
                    throw new InvalidPasswordException(attempLeft, "Invalid Password:");
                }
                System.out.println("User loggedin successfully");
            }
            throw new InvalidPasswordException(attempLeft, "Can't Login:");
        } catch (InvalidPasswordException e) {
            System.out.println(e.getMessage()+" "+e.getAttemptLeft()+" attempt left");
        }
    }

}

public class Task4 {
    public static void main(String[] args) {
        LoginSystem ls = new LoginSystem();
        ls.login("Hello");
        ls.login("Hello");
        ls.login("Hello");
        ls.login("Hello");
    }
}
