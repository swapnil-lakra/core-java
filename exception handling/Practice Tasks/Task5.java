class OutOfStockException extends RuntimeException {
    String productName;

    OutOfStockException(String productName){
        this.productName = productName;
    }
}

class Inventory {

    void checkStock(String product){
        int stock = 0;

        if(stock == 0){
            throw new OutOfStockException(product);
        }

        System.out.println(product+" is available");
    }
}

public class Task5 {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        try {
            inventory.checkStock("Milk");
        } catch (OutOfStockException e) {
            System.out.println("Product out of stock: "+e.productName);
        }
    }    
}
