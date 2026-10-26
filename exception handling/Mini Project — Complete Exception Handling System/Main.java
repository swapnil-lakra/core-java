import java.io.IOException;

class OrderException extends Exception {
    private final String orderId;

    OrderException(String orderId, String msg, Throwable cause){
        super(msg,cause);
        this.orderId = orderId;
    }

    String getOrderId(){ return orderId; }
}

class OrderService {
    void placeOrder(String orderId, double amount, String paymentMode) throws OrderException {
        try {
            validate(orderId,amount);
            processPayment(paymentMode,amount);
            System.out.println("Order "+orderId+" placed successfully");
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw new OrderException(orderId, "Validation failed: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new OrderException(orderId, "Payment failed", e);
        }
    }

    private void validate(String orderId, double amount){
        if(orderId == null || orderId.isBlank()){
            throw new IllegalArgumentException("Order ID required");
        }

        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be positive, got: "+amount);
        }
    }

    private void processPayment(String mode, double amount) throws IOException {
        if(mode.equals("offile")){
            throw new IOException("Gateway unreached");
        }

        if(mode.equals("fraud")){
            throw new IllegalStateException("Fraud detected");
        }

        System.out.println("Payment of "+amount+" via "+mode+" Ok");
    }
}

public class Main {
    public static void main(String[] args) {
        OrderService svc = new OrderService();

        //case 1: success
        runCase("ORD-1",500,"upi");
        
        //case 2: validation failure
        runCase("ORD-2",-100,"upi");

        //case 3: IO Failure
        runCase("ORD-3",500,"offline");

        //case 4: state failure
        runCase("ORD-4",500,"fraud");

        //case 5: null id
        runCase(null,500,"upi");
    }

    static void runCase(String id, double amount, String mode){
        OrderService svc = new OrderService();
        System.out.println("\n--- "+id+" | "+amount+" | "+mode+" ---");

        try {
            svc.placeOrder(id, amount, mode);
        } catch (OrderException e) {
            System.out.println("FAILED ["+e.getOrderId()+"]: "+e.getMessage());
            System.out.println(" Cause: "+e.getCause().getClass().getSimpleName()+" - "+e.getCause().getMessage());
        }
    }
}
