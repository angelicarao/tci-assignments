package school;

import exceptions.CourseDateException;

import java.util.Date;

/**
 * A class representing a course in a school.
 */
public class Course {
    private String name;
    private Date startDate;
    private Date endDate;

    /**
     * Initializes a new instance of this class.
     * @param name The name of the course.
     * @param startDate The start date of the course.
     * @param endDate The end date of the course.
     * @throws CourseDateException Thrown if <code>endDate</code> is before <code>startDate</code>.
     */
    public Course(String name, Date startDate, Date endDate) throws CourseDateException {
        if (endDate.before(startDate))
            throw new CourseDateException();

        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
