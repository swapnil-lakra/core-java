class Book {
    private String title,author;
    private double price;

    Book(String title,String author,double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void getBook(){
        System.out.println("Book Title : "+title+", Author : "+author+", Price : "+price);
    }
}

public class Task1 {
    public static void main(String[] args) {
        Book[] books = new Book[]{new Book("C Programming", "Denis Rithie", 500),
                                  new Book("C++ Programming", "Bjarne Stroustrup", 600),
                                  new Book("Java Programming", "James Goslin", 800),
                                  new Book("Python Programming", "Guido van Rossum", 700),
                                  new Book("JavaScript", "Brendan Eich", 600),
                                };
        
        for(Book b : books){
            b.getBook();
        }

        
    }
}
