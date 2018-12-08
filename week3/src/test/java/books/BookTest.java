package books;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookTest {

    public final String BOOK_NAME = "Book";
    public final String BOOK_AUTHOR = "Author";
    public final String CHAPTER_NAME = "Chapter";
    public final String CHAPTER_NR = "2.1";

    @Test(expected = IllegalArgumentException.class)
    public void bookNameIsNotNull() {
        Book book = new Book(null, BOOK_AUTHOR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bookNameIsNotEmpty() {
        Book book = new Book("", BOOK_AUTHOR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bookAuthorIsNotNull() {
        Book book = new Book(BOOK_NAME, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bookAuthorIsNotEmpty() {
        Book book = new Book(BOOK_NAME, "");
    }

    @Test
    public void addChapterToBook() {
        Book book = mock(Book.class);
        book.addChapter("name", "2.1");

        verify(book).addChapter("name", "2.1");
    }

    @Test
    public void getTableOfContentsContainsChapter() {
        Book book = new Book(BOOK_NAME, BOOK_AUTHOR);

        book.addChapter(CHAPTER_NAME, CHAPTER_NR);

        Assert.assertTrue(book.getTOC().contains(new Chapter(CHAPTER_NAME, CHAPTER_NR)));
    }
}
