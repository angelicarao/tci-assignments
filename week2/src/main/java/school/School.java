package school;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

/**
 * A class representing a school.
 */
public class School {
    private String name;
    private Date openingDate;
    private List<Course> courses;

    public School(String name, Date openingDate) {
        this.name = name;
        this.openingDate = openingDate;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) throws DataFormatException {
        if (course.getStartDate().before(this.openingDate))
            throw new DataFormatException();
        this.courses.add(course);
    }
}
