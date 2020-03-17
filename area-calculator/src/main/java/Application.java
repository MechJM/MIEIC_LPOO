public class Application {
    public static void main(String[] args) {
        AreaAggregator aggregator = new AreaAggregator();
        Square square = new Square(3);
        Circle circle = new Circle(3);
        aggregator.addShape(square);
        aggregator.addShape(circle);

        AreaStringOutputter stringOutputter = new AreaStringOutputter(aggregator);
        AreaXMLOutputter xmlOutputter = new AreaXMLOutputter(aggregator);

        System.out.println(stringOutputter.output());
        System.out.println(xmlOutputter.output());
    }
}
