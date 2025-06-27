package CollegeAlgorithms;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Random;
public class LabSixDeque {
    Deque<Long> dequeLong = new ArrayDeque<>(); //створення деку
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LabSixDeque labSixDeque = new LabSixDeque();
        labSixDeque.fillWithRandom();
        labSixDeque.start();
    }

    //функція заповнення деку рандомними числами
    private void fillWithRandom(){
        Random random = new Random();
        int quantity = 5;
        for (int i = 0; i < quantity; i++){
            dequeLong.push(random.nextLong(10000000));
        }
        System.out.println("The deque with random numbrs: " + dequeLong);
    }

    //функція додавання елементу
    private void addElement(){
        System.out.print("Enter a number: ");
        long element = scanner.nextLong();
        System.out.println("Where to end the element?");
        System.out.println("To the start - push 1");
        System.out.println("To the end - push 2");
        int index = scanner.nextInt();

        switch (index){
            case 1:
                dequeLong.addFirst(element);
                break;
            case 2:
                dequeLong.addLast(element);
                break;
        }
        System.out.println("Deque after adding: " + dequeLong);
    }

    //функція прочитання елементу з деку
    private void readElement(){
        System.out.println("Where to read the element?");
        System.out.println("At the start - push 1");
        System.out.println("At the end - push 2");
        int index = scanner.nextInt();

        switch (index){
            case 1:
                System.out.println(dequeLong.getFirst());
                break;
            case 2:
                System.out.println(dequeLong.getLast());
                break;
        }
    }

    //функція запуску програми
    public void start(){
        boolean run = true;
        while (run){
            System.out.println("Menu");
            System.out.println("1 - Add the element");
            System.out.println("2 - Read the element");
            System.out.println("3 - Show the deque");
            System.out.println("4 - Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    addElement();
                    break;
                case 2:
                    readElement();
                    break;
                case 3:
                    System.out.println(dequeLong);
                    break;
                case 4:
                    System.out.println("End of the program");
                    run = false;
                    break;
                default:
                    System.out.println("You entered the wrong number");
            }
        }
    }
}
