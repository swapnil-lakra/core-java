class Address {
    String city;
    Address(String city){
        this.city = city;
    }
}

class User implements Cloneable {
    String name;
    Address address;

    User(String name, Address address){
        this.name = name;
        this.address = address;
    }

    // shallow clone
    protected User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
    
    // deep clone
    User deepClone() throws CloneNotSupportedException {
        User cloned = (User) super.clone();
        cloned.address = new Address(this.address.city);
        return cloned; 
    }

    @Override 
    protected void finalize() throws Throwable {
        System.out.println("finalize() called for: "+name);
        super.finalize();
    }
}



public class Main {
    public static void main(String[] args) throws Exception {
        User u1 = new User("Amit", new Address("Delhi"));

        // shallow clone
        User u2 = u1.clone();
        u2.name = "Amit2";
        u2.address.city = "Mumbai";
        System.out.println("u1.name : "+u1.name);
        System.out.println("u1.address : "+u1.address.city);

        // deep clone
        User u3 = new User("Priya",new Address("Delhi"));
        User u4 = u3.deepClone();
        u4.address.city = "Pune";
        System.out.println("u3.address : "+u3.address.city);
        System.out.println("u4.address : "+u4.address.city);

        // finalze 
        User temp = new User("TempUser", new Address("NoWhere"));
        temp = null;
        System.gc();
        Thread.sleep(500);
    }
}
