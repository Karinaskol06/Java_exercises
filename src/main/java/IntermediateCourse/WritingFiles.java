package IntermediateCourse;
import java.io.FileWriter;
import java.io.IOException;

public class WritingFiles {
    public static void main(String[] args) {
        try {
            FileWriter myWriter = new FileWriter("test.txt");
            myWriter.write("Artemchick skibidi bomba, skibidibidiboma, bidibambomba. Jest sigma");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error was thrown.");
            e.printStackTrace();
        }
    }
}
