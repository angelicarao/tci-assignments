package books;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.verify;

public class BookTest {

    public final String BOOK_NAME = "Book";
    public final String BOOK_AUTHOR = "Author";
    public final String CHAPTER_NAME = "Chapter";
    public final String CHAPTER_NR = "2.1";

    public Book book = new Book(BOOK_NAME, BOOK_AUTHOR);

    @Test(expected = IllegalArgumentException.class)
    public void bookNameIsNotNull() {
        new Book(null, BOOK_AUTHOR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bookNameIsNotEmpty() {
       new Book("", BOOK_AUTHOR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bookAuthorIsNotNull() {
        new Book(BOOK_NAME, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bookAuthorIsNotEmpty() {
        new Book(BOOK_NAME, "");
    }

    @Test
    public void addChapterToBookSucceeds() {
        book.addChapter(CHAPTER_NAME, CHAPTER_NR);
    }

    @Test
    public void getTableOfContentsContainsChapter() {
        book.addChapter(CHAPTER_NAME, CHAPTER_NR);

        Assert.assertTrue(book.getTOC().contains(new Chapter(CHAPTER_NAME, CHAPTER_NR)));
    }
}
