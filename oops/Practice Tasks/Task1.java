import java.util.Arrays;

class Book {
    String title,author;
    int[] chapterPages;

    Book(String title, String author, int[] cp){
        this.title = title;
        this.author = author;
        this.chapterPages = cp;
    }

    //deep copy
    Book(Book other){
        this.title = other.title;
        this.author = other.author;
        this.chapterPages = Arrays.copyOf(other.chapterPages, other.chapterPages.length);
    }
}

// Shallow Copy = Copy of references
// Deep Copy = Copy of values

public class Task1 {
    public static void main(String[] args) {
        Book book1 = new Book("Hashing","Swapnil", new int[]{1,2,3});
        Book book2 = new Book(book1);
        
        book2.author = "Divyansh";
        book2.chapterPages[0] = 10;

        System.out.println("book1.author : "+book1.author);
        System.out.println("book1.chapterPages : "+book1.chapterPages[0]);
    }
}
