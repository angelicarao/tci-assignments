import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
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

    @Test
    public void test_addDoubleToData_shouldBeAdded() {
        bs = new BasicStatistic();
        bs.addDoubleToData(1.11);

        Assert.assertEquals(1, bs.numberOfDataItems());
    }

    @Test
    public void test_clearData() {
        bs = new BasicStatistic();

        bs.addDoubleToData(1.11);
        bs.addDoubleToData(1.11);

        bs.clearData();

        Assert.assertEquals(0, bs.numberOfDataItems());
    }

    @Test
    public void test_numberOfDataItems() {
        bs = new BasicStatistic();
        // Should be 0 initially.
        Assert.assertEquals(0, bs.numberOfDataItems());

        bs.addDoubleToData(1.11);
        bs.addDoubleToData(1.11);
        bs.addDoubleToData(1.11);

        Assert.assertEquals(3, bs.numberOfDataItems());
    }

    @Test
    public void test_sum() {
        bs = new BasicStatistic();
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
        bs = new BasicStatistic();

        bs.addDoubleToData(value1);
        bs.addDoubleToData(value2);

        Assert.assertEquals(value2, bs.highestValue());
    }

    @Test
    public void test_getMean() throws NoDataItemsException {
        bs = new BasicStatistic();

        bs.addDoubleToData(1.00);
        bs.addDoubleToData(2.00);

        Double expectedMean = (1.00 + 2.00) / 2;

        Assert.assertEquals(expectedMean, bs.getMean());
    }

    @Test(expected = NoDataItemsException.class)
    public void test_highestValue_NoDataItemsException() throws NoDataItemsException {
        bs = new BasicStatistic();
        bs.highestValue();
    }

    @Test(expected = NoDataItemsException.class)
    public void test_getMean_NoDataItemsException() throws NoDataItemsException {
        bs = new BasicStatistic();
        bs.getMean();
    }
}