package school;

import exceptions.DuplicateCourseException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
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
        return this.name;
    }

    public Date getOpeningDate() {
        return this.openingDate;
    }

    public List<Course> getCourses() {
        return this.courses;
    }

    /**
     * Adds a course to this school.
     * @param course The course to be added.
     * @throws DataFormatException Thrown if the course's start date is before the opening date of the school.
     * @throws DuplicateCourseException Thrown if a course with the given name already exists.
     */
    public void addCourse(Course course) throws DataFormatException, DuplicateCourseException {
        if (course.getStartDate().before(this.openingDate))
            throw new DataFormatException();

        if (this.courses.stream().anyMatch(c -> c.getName().equals(course.getName())))
            throw new DuplicateCourseException();

        this.courses.add(course);
    }

    /**
     * Gets a course by its name.
     * @param name The name of the course which should be searched for.
     * @return Returns the searched course, or <code>null</code>, if none is found.
     */
    public Course getCourseByName(String name) {
        for (Course course : this.courses) {
            if (course.getName().equals(name))
                return course;
        }
        return null;
    }

    /**
     * Gets a list of all the names of courses in the school.
     * @return A collection of course names.
     */
    public List<String> getAllCourseNames() {
        return this.courses.stream().map(Course::getName).collect(Collectors.toList());
    }

    /**
     * Gets a copy of all courses in the school.
     * @return A collection of all courses in the school.
     */
    public List<Course> getCopyOfAllCourses() {
        return new ArrayList<>(this.courses);
    }
}
