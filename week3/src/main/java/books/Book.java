package books;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private String name;
    private String author;
    private List<Chapter> chapters;

    public Book(String name, String author) {
        if (name == null || name == "" || author == null || author == "")
            throw new IllegalArgumentException();
        this.name = name;
        this.author = author;
        this.chapters = new ArrayList<>();
    }

    public void addChapter(String chapterName, String chapterNumber) {
        Chapter newChapter = new Chapter(chapterName, chapterNumber);
        this.chapters.add(newChapter);
    }
}
