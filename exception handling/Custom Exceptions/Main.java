// Custom Exception 1: Checked
class InsufficientFundException extends Exception {
    private  double balance;
    private double amount;

    public InsufficientFundException(double balance, double amount){
        super("Insufficient funds: balance="+balance+", required="+amount);
        this.balance = balance;
        this.amount = amount;
    }

    public double getShortFall(){
        return balance - amount;
    }
}

// Custom Exception 2: Unchecked
class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(int age){
        super("Invalid age: "+age);
    }
}

// Custom Exception 3: extra fields
class ValidationException extends Exception {
    private final String field;

    public ValidationException(String field, String message){
        super(message);
        this.field = field;
    }

    public String getField(){
        return field;
    }
}

// Custom exception 4: Business Logic
class BankAccount {
    private double balance;

    BankAccount(double balance){
        this.balance = balance;
    }

    void withdraw(double amount) throws InsufficientFundException {
        if(amount > balance){
            throw new InsufficientFundException(balance, amount);
        }

        balance -= amount;
        System.out.println("Withdraw: "+amount+", new balance: "+balance);
    }
}


public class Main {
    public static void main(String[] args) {
        // Checked custom exception
        System.out.println("checked custom exception");
        BankAccount acc = new BankAccount(1000);

        try {
            acc.withdraw(1500);
        } catch (InsufficientFundException e) {
            System.out.println("Error: "+e.getMessage());
            System.out.println("Short by: "+e.getShortFall());
        }

        // Unchecked custom exception
        System.out.println("unchecked custom exception");
        try {
            validateAge(15);
        } catch (InvalidAgeException e) {
            System.out.println("Caught: "+e.getMessage());
        }

        // Extra feilds custom exception
        System.out.println("Validation custom exception");
        try {
            validateEmail("not-an-email");
        } catch (ValidationException e) {
            System.out.println("Field: "+e.getField()+", Message: "+e.getMessage());
        }
    }

    static void validateAge(int age){
        if(age < 18 || age > 120) throw new InvalidAgeException(age);
        System.out.println("Age Ok: "+age);
    }

    static void validateEmail(String email) throws ValidationException {
        if(!email.contains("@")) throw new ValidationException(email, "Invalid format");
        System.out.println("Email is OK");
    }
}
