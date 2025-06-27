package IntermediateCourse.Generics;

public class MainDriver {
    public static void main(String[] args) {
        int myNumber = 24;
        String bookName = "Hello Book!";

        //creating objects and setting them data types
        Retriever<Integer> containerRetriever = new Container<>(myNumber);
        Retriever<String> bookRetriever = new Book(bookName);

        System.out.println(containerRetriever.retrieveData());
        System.out.println(bookRetriever.retrieveData());
    }
}
