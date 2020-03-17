public class Circle implements AreaShape {
    private double radius;

    public Circle(double radius)
    {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){return Math.PI * radius * radius;}

    public void draw(){
        System.out.println("Circle");
    }
}
