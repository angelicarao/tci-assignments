import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class BasicStatisticTest {

    private BasicStatistic bs;

    private static final Object[] getValues() {
        return new Object[] {
                new Object[] {1.0, 2.0},
                new Object[] {10.0, 20.0}
        };
    }

    private static final Object[] getMeans() {
        return new Object[] {
                new Object[] {1.0, 2.0, 3.0},
                new Object[] {10.0, 20.0, 30.0}
        };
    }

    @Before
    public void setUp() {
        bs = new BasicStatistic();
    }

    @Test
    public void test_addDoubleToData_shouldBeAdded() {
        bs.addDoubleToData(1.11);

        Assert.assertEquals(1, bs.numberOfDataItems());
    }

    @Test
    public void test_clearData() {
        bs.addDoubleToData(1.11);
        bs.addDoubleToData(1.11);

        bs.clearData();

        Assert.assertEquals(0, bs.numberOfDataItems());
    }

    @Test
    public void test_numberOfDataItems() {
        // Should be 0 initially.
        Assert.assertEquals(0, bs.numberOfDataItems());

        bs.addDoubleToData(1.11);
        bs.addDoubleToData(1.11);
        bs.addDoubleToData(1.11);

        Assert.assertEquals(3, bs.numberOfDataItems());
    }

    @Test
    public void test_sum() {
        Double value = 1.11;

        bs.addDoubleToData(value);
        bs.addDoubleToData(value);
        bs.addDoubleToData(value);

        Double expectedSum = value + value + value;

        Assert.assertEquals(expectedSum, bs.sum());
    }

    @Test
    @Parameters(method = "getValues")
    public void test_highestValue(Double value1, Double value2) throws NoDataItemsException {
        bs.addDoubleToData(value1);
        bs.addDoubleToData(value2);

        Assert.assertEquals(value2, bs.highestValue());
    }

    @Test
    @Parameters(method = "getMeans")
    public void test_getMean(Double m1, Double m2, Double m3) throws NoDataItemsException {
        bs.addDoubleToData(m1);
        bs.addDoubleToData(m2);
        bs.addDoubleToData(m3);

        Double expectedMean = (m1 + m2 + m3) / 3;

        Assert.assertEquals(expectedMean, bs.getMean());
    }

    @Test(expected = NoDataItemsException.class)
    public void test_highestValue_NoDataItemsException() throws NoDataItemsException {
        bs.highestValue();
    }

    @Test(expected = NoDataItemsException.class)
    public void test_getMean_NoDataItemsException() throws NoDataItemsException {
        bs.getMean();

    }
}