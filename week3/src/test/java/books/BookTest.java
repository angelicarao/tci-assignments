package books;

import org.junit.Test;

public class BookTest {

    @Test(expected = IllegalArgumentException.class)
    public void bookNameIsNotNull() {
        Book book = new Book(null, "Hans");
    }

    @Test(expected = IllegalArgumentException.class)
    public void bookNameIsNotEmpty() {
        Book book = new Book("", "Hans");
    }
}
