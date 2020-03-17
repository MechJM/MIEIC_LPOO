public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();
        aggregator.addHasArea(new Square(3));
        aggregator.addHasArea(new Circle(3));
        aggregator.addHasArea(new Triangle(2,2));
        aggregator.addHasArea(new House(3,2));

        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aggregator);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());
    }
}
