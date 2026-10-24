class Person{
    String name;
    int age;

    // field vs parameter disambigute
    Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    // constructor chaining
    Person(String name){
        this(name,0);
    }

    // current object ka method call
    void display(){
        System.out.println("Name: "+this.name);
        this.printRole();
    }

    void printRole(){
        System.out.println("I am a Person");
    }

    // current object return / pass
    Person getSelf(){
        return this; 
    }

    void greet(Person p){
        System.out.println("Hello "+p.name);
    }

    void selfGreet(){
        greet(this);
    }
}

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Amit",22);
        p.display();
        p.selfGreet();

        // Chaining is possible through return this
        Person same = p.getSelf();
        System.out.println("Same Object? "+(p == same));
    }
}
