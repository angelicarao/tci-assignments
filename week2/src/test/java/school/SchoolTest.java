package school;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class SchoolTest {

    private School school;

    @Test
    public void initializeSchool() {
        school = new School("school", new Date(2018,01,01));

        Assert.assertNotNull(school.getName());
        Assert.assertNotNull(school.getOpeningDate());
        Assert.assertNotNull(school.getCourses());
    }
}