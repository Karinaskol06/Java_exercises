package CollegeAlgorithms;

import java.util.Stack;
import java.util.Random;

public class StackTask {
    public static void main(String[] args) {
        Stack<Long> stack = new Stack<>(); //створення стеку типу long

        System.out.println("Adding random elements to the stack ");
        Random random = new Random(); //бібліотека Random
        for (int i = 0; i < 10; i++){
            long randomEl = -100000 + (long) (random.nextDouble() * (100000 - (-100000) + 1));
            //генерування рандомного елементу типу long в межах від -100000 до 100000
            stack.push(randomEl); //додавання цього елементу до стеку
        }
        System.out.println(stack); //виведення поточного стану стеку

        System.out.println("Removing elements from the stack ");
        System.out.println("The last element of the stack is: " + stack.peek()); //знаходження останнього елементу
        stack.pop(); //функція видалення елементу з кінця стеку
        System.out.println(stack);
        System.out.println("Size of the stack now equals to: " + stack.size());

        System.out.println("Displaying the stack using a loop: ");
        for (Long aLong : stack) { //ітерація по елементах стеку і виведення його в консолі
            System.out.print(aLong + " ");
        }



    }
}
