import java.util.ArrayList;
import java.util.List;

public class AreaAggregator {
    private List<HasArea> HasAreas = new ArrayList<>();

    public void addHasArea(HasArea HasArea) {
        HasAreas.add(HasArea);
    }

    public double sum() {
        double sum = 0;
        for (HasArea HasArea: HasAreas) {
            sum += HasArea.getArea();
        }
        return sum;
    }




}

