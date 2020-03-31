package com.aor.refactoring.example2;

public class Shape {
    protected double x;
    protected double y;

    public Shape(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getArea()  {
       return 0;
    }

    public double getPerimeter() {
       return 0;
    }

    public void draw(GraphicFramework graphics) {

    }
}
