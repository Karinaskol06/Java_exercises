package IntermediateCourse;

import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Deserialization implements Serializable {
    private String make;
    private int year;
    private static final long serialVersionUID = 1L;

    public Deserialization(String make, int year) {
        this.make = make;
        this.year = year;
    }

    public String toString(){
        return String.format("Deserialization make is: %s, Deserialization year is: %d", this.make, this.year);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Deserialization toyota = new Deserialization("Toyota", 2021);
        Deserialization honda = new Deserialization("Honda", 2020);
        FileOutputStream fileOutputStream = new FileOutputStream("cars.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(toyota);
        objectOutputStream.writeObject(honda);

        FileInputStream fileInputStream = new FileInputStream("cars.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Deserialization toyotaCopy = (Deserialization) objectInputStream.readObject();
        Deserialization hondaCopy = (Deserialization) objectInputStream.readObject();

        boolean isSameObject = toyotaCopy == toyota;
        System.out.println(toyota);
        System.out.println(toyotaCopy);
        System.out.println(isSameObject); //are not same as the serialization copies an object,
        //not references it
    }
}