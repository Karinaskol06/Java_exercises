package IntermediateCourse;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFiles {
    public static void main(String[] args) {
        try {
            FileReader myReader = new FileReader("test.txt");
            int i;
            while ((i = myReader.read()) != -1)
                System.out.print((char)i);
            myReader.close();
        } catch (IOException e) {
            System.out.println("An error was thrown.");
            e.printStackTrace();
        }
    }
}
