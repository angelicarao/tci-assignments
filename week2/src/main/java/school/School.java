package school;

import exceptions.DuplicateCourseException;

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

    public void addCourse(Course course) throws DataFormatException, DuplicateCourseException {
        if (course.getStartDate().before(this.openingDate))
            throw new DataFormatException();

        if (courses.stream().anyMatch(c -> c.getName().equals(course.getName())))
            throw new DuplicateCourseException();

        this.courses.add(course);
    }

    /**
     * Gets a course by its name.
     * @param name The name of the course which should be searched for.
     * @return Returns the searched course, or <code>null</code>, if none is found.
     */
    public Course getCourseByName(String name) {
        for (Course course : courses) {
            if (course.getName().equals(name))
                return course;
        }
        return null;
    }
}
