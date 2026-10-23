import java.util.*;

interface Animal {
    void sound();
}

class Dog implements Animal {
    @Override 
    public void sound(){
        System.out.println("Woof");
    }
}

class Cat implements Animal {
    @Override 
    public void sound(){
        System.out.println("Meow");
    }
}


public class Main {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.sound();
        a2.sound();

        Animal[] zoo = { new Dog(), new Cat(), new Dog()};

        for(Animal a : zoo){
            a.sound();
        }

        List<Animal> list = new ArrayList<>();
        list.add(new Dog());
        list.add(new Cat());
        
        for(Animal a : list){
            a.sound();
        }
    }
}
