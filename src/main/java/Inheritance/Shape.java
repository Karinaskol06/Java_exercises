package Inheritance;

//general abstract superclass
abstract class Shape {
    public String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }

    //abstract methods (should be applicable for all shapes)
    abstract void draw();
}
