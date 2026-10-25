import java.util.Set;
import java.util.HashSet;

class Product {
    int id;
    String name;
    double price;

    Product(int id,String name,double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override 
    public String toString(){
        return "Product id:"+id+" name:"+name+" price:"+price;
    }

    @Override 
    public boolean equals(Object o){
        if(o == null || (!(o instanceof Product))) return false;
        Product other = (Product) o;
        return id == other.id && name.equals(other.name) && price == other.price;
    }

    @Override 
    public int hashCode(){
        return 31 * id + (int)price;
    }
}

public class Task8 {
    public static void main(String[] args) {
        HashSet<Product> uniqueProductSet = new HashSet<>();
        uniqueProductSet.add(new Product(101, "Washing Dish", 30)); 
        uniqueProductSet.add(new Product(101, "Washing Dish", 30)); 
        uniqueProductSet.add(new Product(102, "Tissue Paper", 50)); 

        System.out.println("uniqueProductSet.size() : "+uniqueProductSet.size());
        System.out.println("uniqueProductSet : "+uniqueProductSet);
    }
}
