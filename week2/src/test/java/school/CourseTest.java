package school;

import exceptions.CourseDateException;
import org.junit.Test;

import java.util.Date;

public class CourseTest {

    private Course course;

    @Test(expected = CourseDateException.class)
    public void newCourseWithInvalidEndDate() throws CourseDateException {
        course = new Course("test", new Date(2018, 01, 01), new Date(2017,01,01));
    }

}