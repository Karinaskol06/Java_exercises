package IntermediateCourse;

import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AssosFieldSerial implements Serializable {
    private String make;
    private int year;
    private static final long serialVersionUID = 1L;
    private Engine engine; //engine object

    public AssosFieldSerial(String make, int year) {
        this.make = make;
        this.year = year;
        this.engine = new Engine(2.4, 6); //automatically set, but can be changed
    }

    public String toString() {
        return String.format("CustomSerialize make is: %s, CustomSerialize year is: %d, %s", this.make, this.year, this.engine);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        //initializing objects
        AssosFieldSerial toyota = new AssosFieldSerial("Toyota", 2021);
        AssosFieldSerial honda = new AssosFieldSerial("Honda", 2020);

        //serializing them
        FileOutputStream fileOutputStream = new FileOutputStream("cars.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(toyota);
        objectOutputStream.writeObject(honda);

        //deserializing them
        FileInputStream fileInputStream = new FileInputStream("cars.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        AssosFieldSerial toyotaCopy = (AssosFieldSerial) objectInputStream.readObject();
        AssosFieldSerial hondaCopy = (AssosFieldSerial) objectInputStream.readObject();

        boolean isSameObject = toyotaCopy == toyota;
        System.out.println("Toyota (Copy) - "+toyotaCopy);
        System.out.println("Toyota (Original) - "+toyota);
        System.out.println("Is same object: "+ isSameObject);
    }
}

//