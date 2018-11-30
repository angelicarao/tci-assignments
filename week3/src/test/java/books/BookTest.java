package books;

import org.junit.Test;

public class BookTest {

    @Test(expected = IllegalArgumentException.class)
    public void bookNameIsNotNull() {
        Book book = new Book(null, "Hans");
    }
}
