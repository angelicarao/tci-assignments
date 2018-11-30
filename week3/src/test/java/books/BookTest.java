package books;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {

    @Test(expected = IllegalArgumentException.class)
    public void bookNameIsNotNull() {
        Book book = new Book(null, "Hans");
    }

    @Test(expected = IllegalArgumentException.class)
    public void bookNameIsNotEmpty() {
        Book book = new Book("", "Hans");
    }

    @Test(expected = IllegalArgumentException.class)
    public void bookAuthorIsNotNull() {
        Book book = new Book("name", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bookAuthorIsNotEmpty() {
        Book book = new Book("name", "");
    }

    @Test
    public void addChapterToBook() {
        Book book = mock(Book.class);
        book.addChapter("name", "2.1");

        verify(book).addChapter("name", "2.1");
    }
}
