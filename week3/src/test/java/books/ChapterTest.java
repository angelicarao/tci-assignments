package books;

import org.junit.Assert;
import org.junit.Test;

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
    public void chapterImplementsComparable() {
        Assert.assertTrue(new Chapter("c", "1.1") instanceof Comparable);
    }
}
