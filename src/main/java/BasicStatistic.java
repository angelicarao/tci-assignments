import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * very simple implementation of the BasicStatisticInterface
 */
public class BasicStatistic implements BasicStatisticInterface {
    private List<Double> data;

    public BasicStatistic() {
        this.data = new ArrayList<>();
    }

    @Override
    public void addDoubleToData(Double valueToAdd) {
        this.data.add(valueToAdd);
    }

    @Override
    public void clearData() {
        this.data.clear();
    }

    @Override
    public int numberOfDataItems() {
        return this.data.size();
    }

    @Override
    public Double sum() {
        double sum = 0.0;
        for (Double d: data) {
            sum += d;
        }
        return sum;
    }

    @Override
    public Double highestValue() throws NoDataItemsException {
        if (this.data.size() > 0)
            return Collections.max(this.data);
        throw new NoDataItemsException();
    }

    @Override
    public Double getMean() throws NoDataItemsException {
        if (this.data.size() > 0) {
            Double sum = 0.0;
            for (int i = 0; i < data.size(); i++) {
                sum += data.get(i);
            }
            return sum / data.size();
        }
        throw new NoDataItemsException();
    }

    @Override
    public double getMedian() throws NoDataItemsException {
        double rv = 0.0;
        return rv;
    }

    @Override
    public double getStandardDeviation() throws NoDataItemsException {
        double rv = 0.0;
        return rv;
    }
}
