package Inheritance;

public class Rectangle extends TwoDShape{
    private final double length;
    private final double width;

    public Rectangle(String c, double length, double width) {
        super(c);
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }
    public double getWidth() {
        return width;
    }

    //specific implementation for abstract methods
    @Override
    public double getArea(){
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return (length + width) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle of length: " + getLength() + ", width: " + getWidth()
                + ", area: " + getArea() + ", perimeter: " + getPerimeter();
    }
}
