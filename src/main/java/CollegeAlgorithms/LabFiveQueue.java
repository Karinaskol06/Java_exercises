package CollegeAlgorithms;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class LabFiveQueue {
    private static Queue<Long> longQueue = new LinkedList<>(); //linked list реалізує функції черги
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        boolean isWorking = true;
        while(isWorking){
            System.out.println("***Menu***");
            System.out.println("1 - Add element to the queue");
            System.out.println("2 - Read element from the queue");
            System.out.println("3 - Print the queue");
            System.out.println("4 - Exit program");
            System.out.print("\nPress the number: ");

            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter element which you want to add to the queue");
                    long el = scanner.nextLong();
                    longQueue.add(el);
                    System.out.println("Element " + el + " was added to the queue");
                    break;
                case 2:
                    if(!longQueue.isEmpty()){
                        Queue<Long> longQueueCopy = new LinkedList<>(longQueue); //створення копії початкової черги
                        long el2 = longQueueCopy.poll(); //елемент з початку черги
                        System.out.println("Element " + el2 + " was read from the head of the queue");
                    } else{
                        System.out.println("Queue is empty. We cannot read the element");
                    }
                    break;
                case 3:
                    System.out.print("Printing the queue: ");
                    System.out.println(longQueue);
                    break;
                case 4:
                    System.out.println("***Exitting program***");
                    isWorking = false;
                    break;
                default:
                    System.out.println("You've entered the wrong number!");
            }
        }

    }
}
