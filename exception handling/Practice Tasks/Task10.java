class InsufficientFundException extends  Exception {
    private double shortFall;
    
    InsufficientFundException(double shortFall){
        super("Insufficient funds. Shortfall: "+shortFall);
        this.shortFall = shortFall;
    }

    double getShortFall(){
        return shortFall;
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void withdraw(double amount) throws InsufficientFundException {
        if(amount <= 0){
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }

        if(amount > balance){
            double shortFall = amount - balance;
            throw new InsufficientFundException(shortFall);
        }

        balance -= amount;
    }

    public void deposit(double amount){
        if(amount <  0){
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
    }

    public void transfer(BankAccount to, double amount) throws InsufficientFundException {

        double senderOriginalBalance = this.balance;
        double receiverOriginalBalance = to.balance;

        try {
            this.withdraw(amount);
            to.deposit(amount);

            System.out.println("Transfer successful!");
        } catch (InsufficientFundException | RuntimeException e) {
            this.balance = senderOriginalBalance;
            to.balance = receiverOriginalBalance;

            System.out.println("Transfer failed. Rollback completed");

            throw e;
        }
    }
}

class FailingDepositAccount extends BankAccount {
    public FailingDepositAccount(double balance){
        super(balance);
    }

    @Override 
    public void deposit(double amount){
        throw new IllegalArgumentException("Simulated receiver deposit failure");
    }
}

public class Task10 {
    static void printException(Exception e){
        System.out.println("Message: "+e.getMessage());
        System.out.println("Cause: "+e.getCause());

        if(e instanceof InsufficientFundException){
            InsufficientFundException ex = (InsufficientFundException) e;
            System.out.println("Shortfall: "+ex.getShortFall());
        }
    }
    public static void main(String[] args) {
        
        System.out.println("Scenario 1: Withdraw");
        BankAccount a1 = new BankAccount(1000);
        try {
            a1.withdraw(200);
            System.out.println("Balance: "+a1.getBalance());
        } catch (InsufficientFundException e) {
            printException(e);
        } catch (RuntimeException e) {
            printException(e);
        }

        System.out.println("Scenario 2: Insufficient Funds");
        BankAccount a2 = new BankAccount(1000);
        try {
            a2.withdraw(1500);
        } catch (InsufficientFundException e) {
            printException(e);
        } catch (RuntimeException e) {
            printException(e);
        }

        System.out.println("Scenario 3: Negative Deposit");
        BankAccount a3 = new BankAccount(500);
        try {
            a3.deposit(-100);
        } catch (RuntimeException e) {
            printException(e);
        }

        System.out.println("Scenario 4: Successful Transfer");
        BankAccount sender = new BankAccount(1000);
        BankAccount receiver = new BankAccount(500);

        try {
            sender.transfer(receiver, 300);

            System.out.println("Sender balance: "+sender.getBalance());
            System.out.println("Sender balance: "+sender.getBalance());
        } catch (InsufficientFundException e) {
            printException(e);
        } catch (RuntimeException e) {
            printException(e);
        }

        System.out.println("Scenario 5: Rollback");
        BankAccount sender2 = new BankAccount(1000);
        BankAccount receiver2 = new FailingDepositAccount(500);

        try {
            sender2.transfer(receiver2, 300);
        } catch (InsufficientFundException e) {
            printException(e);
        } catch (RuntimeException e) {
            printException(e);
        }

        System.out.println("Sender balance after rollback: "+sender2.getBalance());
        System.out.println("Receiver balance after rollback: "+receiver2.getBalance());
    }
}
