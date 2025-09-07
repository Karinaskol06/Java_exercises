package Inheritance;

//another layer of superclasses
abstract class ThreeDShape extends Shape {
    public double depth;

    //super constructor from the superclass
    public ThreeDShape(String color, double depth) {
        super(color);
        this.depth = depth;
    }

    //abstract methods
    public abstract String toString();
    abstract double getVolume();

    //non-abstract method
    public void showInfo(){
        System.out.println("This is a three dimensional shape");
    }

    @Override
    void draw() {
        System.out.println("Drawing 3D shape...");
    }
}
