package school;

import exceptions.CourseDateException;
import exceptions.DuplicateCourseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;
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

    @Test
    public void getCourseByName() throws CourseDateException, DataFormatException, DuplicateCourseException {
        Course expected = new Course("testCourse", new Date(2018,01,01), new Date(2018,05,01));
        school.addCourse(expected);

        Course actual = school.getCourseByName(expected.getName());

        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getStartDate(), actual.getStartDate());
        Assert.assertEquals(expected.getEndDate(), actual.getEndDate());
    }

    @Test
    public void getAllCourseNames() throws CourseDateException, DataFormatException, DuplicateCourseException {
        Course c1 = new Course("testCourse1", new Date(2018,01,01), new Date(2018,05,01));
        Course c2 = new Course("testCourse2", new Date(2018,01,01), new Date(2018,05,01));
        school.addCourse(c1);
        school.addCourse(c2);

        List<String> names = school.getAllCourseNames();

        Assert.assertTrue(names.contains(c1.getName()));
        Assert.assertTrue(names.contains(c2.getName()));
    }

    @Test
    public void getCopyOfAllCourses() throws CourseDateException, DataFormatException, DuplicateCourseException {
        Course c1 = new Course("testCourse1", new Date(2018,01,01), new Date(2018,05,01));
        Course c2 = new Course("testCourse2", new Date(2018,01,01), new Date(2018,05,01));
        school.addCourse(c1);
        school.addCourse(c2);

        List<Course> actual = this.school.getCopyOfAllCourses();

        Assert.assertEquals(2, actual.size());
        Assert.assertTrue(actual.contains(c1));
        Assert.assertTrue(actual.contains(c2));
    }
}
