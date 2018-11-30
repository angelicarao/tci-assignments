package books;

public class Chapter implements Comparable {
    private String number;
    private String chapterName;

    public Chapter(String chapterName, String number) {
        if (chapterName == null)
            throw new IllegalArgumentException();
        if (number.length() > 3)
            throw new IllegalArgumentException();

        this.chapterName = chapterName;
        this.number = number;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
