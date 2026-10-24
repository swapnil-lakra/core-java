class Animal {
    void sound(){
        System.out.println("Some animal sound");
    }

    void eat(){
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    @Override 
    void sound(){
        System.out.println("Woof Woof!");
    }

    @Override 
    void eat(){
        super.eat();
        System.out.println("Dog eating bones");
    }
}

class Cat extends Animal {
    @Override 
    void sound(){
        System.out.println("Meow Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a;
        a = new Dog();
        a.sound();
        a.eat();

        a = new Cat();
        a.sound();

        Animal[] zoo = new Animal[]{ new Dog(), new Cat(), new Dog()};
        System.out.println("--- Zoo ---");
        for(Animal x : zoo){
            x.sound();
        }

    }
}
