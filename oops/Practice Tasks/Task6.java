class Animal {
    Animal(){
        System.out.println("Animal constructor");
    }

    Animal reproduce(){
        return this;
    }
}

class Dog extends Animal{
    Dog(){
        System.out.println("Dog constructor");
    }

    @Override 
    Dog reproduce(){
        return this;
    }
}

public class Task6 {
    public static void main(String[] args) {
        Animal a = new Animal();
        Animal a1 = a.reproduce();

        Dog d = new Dog();
        Dog d1 = d.reproduce();

        Animal a2 = d1.reproduce();
    }    
}
