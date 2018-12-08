package books;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ChapterTest {

    @Test(expected = IllegalArgumentException.class)
    public void chapterNameCannotBeNull() {
        Chapter c = new Chapter(null, "2.1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void chapterNumberHasMaxTwoLevelsOfChapter() {
        Chapter c = new Chapter("chapter", "2.11");
    }

    @Test
    public void chapterComparesTwoChaptersCorrectly() {
        Chapter chapterA = new Chapter("c", "1.1");
        Chapter chapterB = new Chapter("c", "1.1");

        assertThat(chapterA.compareTo(chapterB), is(0));
    }

    @Test
    public void chapterOverridesEqualsSucceeds() {
        Chapter chapterA = new Chapter("c", "2");
        Chapter chapterB = new Chapter("c", "2");

        assertThat(chapterA, is(chapterB));
    }

    @Test
    public void chapterOverridesHashcode() {
        Chapter c = new Chapter("a", "2.1");
        assertThat(c.hashCode(), is(1));
    }
}
