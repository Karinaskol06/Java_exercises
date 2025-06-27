package IntermediateCourse;

import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Serialization implements Serializable {
    private String make;
    private int year;
    private static final long serialVersionUID = 1L;

    public Serialization(String make, int year) {
        this.make = make;
        this.year = year;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Serialization toyota = new Serialization("Toyota", 2021);
        Serialization honda = new Serialization("Honda", 2020);

        FileOutputStream fileOutputStream = new FileOutputStream("cars.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(toyota);
        objectOutputStream.writeObject(honda);
    }
}
