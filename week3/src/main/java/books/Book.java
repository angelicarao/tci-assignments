package books;

public class Book {

    private String name;
    private String author;

    public Book(String name, String author) {
        if (name == null || name == "")
            throw new IllegalArgumentException();
    }
}
