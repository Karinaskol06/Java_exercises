package Inheritance;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("Turquoise", 10, 8);
        Sphere sphere = new Sphere("Orange", 3, 9);

        System.out.println(rectangle);
        rectangle.showInfo();
        rectangle.draw();

        System.out.println(sphere);
        sphere.showInfo();
        sphere.draw();
    }
}
