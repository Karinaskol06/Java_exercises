package Inheritance;

public class Sphere extends ThreeDShape{
    private final double radius;

    public Sphere(String color, double depth, double radius) {
        super(color, depth);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Sphere with radius: " + radius + ", depth: " + depth
                + ", color: " + color + ", volume: " + getVolume();
    }

    @Override
    double getVolume() {
        return (4/3) * Math.PI * Math.pow(radius, 3);
    }
}
