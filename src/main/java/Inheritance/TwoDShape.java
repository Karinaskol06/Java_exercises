package Inheritance;

//another layer of abstraction
abstract class TwoDShape extends Shape {
    public TwoDShape(String color) {
        super(color);
    }

    //abstract methods (should be applicable for all shapes)
    public abstract String toString();
    public abstract double getPerimeter();
    public abstract double getArea();

    @Override
    void draw() {
        System.out.println("Drawing 2D Shape...");
    }

    //non-abstract method
    public void showInfo(){
        System.out.println("This is a two dimensional shape");
    }
}
