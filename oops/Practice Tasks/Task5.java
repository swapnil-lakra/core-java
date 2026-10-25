class BankAccount {
    protected double balance;

    BankAccount(double balance){
        this.balance = balance;
    }

    void withdraw(double amount){
        balance -= amount;
    }
}

class SavingsAccount extends BankAccount {

    SavingsAccount(double balance){
        super(balance);
    }
    
    @Override 
    void withdraw(double amount){
        super.withdraw(amount);
        System.out.println("After "+amount+" is withdrawn minimum-balance is "+balance);
    }
}

public class Task5 {
    public static void main(String[] args) {
        BankAccount sa = new SavingsAccount(1000);
        sa.withdraw(300);
    }
}
