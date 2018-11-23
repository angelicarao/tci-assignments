package school;

import exceptions.CourseDateException;
import exceptions.DuplicateCourseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.zip.DataFormatException;

public class SchoolTest {

    private School school;

    @Before
    public void testInit() {
        school = new School("school", new Date(2018,01,01));
    }

    @Test
    public void initializeSchool() {
        Assert.assertNotNull(school.getName());
        Assert.assertNotNull(school.getOpeningDate());
        Assert.assertNotNull(school.getCourses());
    }

    @Test
    public void addCourse() throws CourseDateException, DataFormatException, DuplicateCourseException {
        school.addCourse(new Course("testCourse", new Date(2018,01,01), new Date(2018,05,01)));

        Assert.assertEquals(1, school.getCourses().size());
    }

    @Test(expected = DataFormatException.class)
    public void courseBeginDateBeforeSchoolBeginDate() throws CourseDateException, DataFormatException, DuplicateCourseException {
        school.addCourse(new Course("testCourse", new Date(2017,01,01), new Date(2018,05,01)));
    }

    @Test(expected = DuplicateCourseException.class)
    public void uniqueCourseNameWithinSchool() throws CourseDateException, DataFormatException, DuplicateCourseException {
        Course c = new Course("testCourse", new Date(2018,01,01), new Date(2018,05,01));
        school.addCourse(c);
        // Should throw DuplicateCourseException
        school.addCourse(c);
    }
}
