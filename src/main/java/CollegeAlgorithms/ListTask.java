package CollegeAlgorithms;
import java.util.LinkedList;
import java.util.Scanner;

public class ListTask {
    public static void main(String[] args) {
        int K;
        long val;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of elements in the list: ");
        K = scan.nextInt();

        LinkedList<Long> list = new LinkedList<>(); //створення лінійного зв'язаного списку
        System.out.print("Enter the elements of the list in a row: ");
        for (int i = 0; i < K; i++) {
            list.add(scan.nextLong()); //додавання елементів типу long до списку з клавіатури
        }

        for (int i = 0; i < K; i++) {
            System.out.print(list.get(i) + " "); //виведення списку
        }

        //пошук елементу в списку
        System.out.print("\nEnter the number to search for: ");
        val = scan.nextLong(); //введення елементу для пошуку

        boolean foundVal = false; //визначає чи знайдене значення у списку
        System.out.print("Elements that equal to " + val + " are found at indices: ");
        for (int i = 0; i < K; i++) {
            if (list.get(i) == val) { //пошук елементів в списку і виведення їх індексів
                System.out.print(i + " ");
                foundVal = true;
            }
        }
        if (!foundVal){
            System.out.print("no elements found"); //виведення повідомлення про відсутність числа
        }

        //видалення елементу зі списку
        System.out.print("\nEnter index of element to remove: ");
        int ind = scan.nextInt();
        list.remove(ind); //метод видалення
        System.out.println(list); //виведення списку

        //додавання елементу до списку
        System.out.print("Enter the value of element to add: ");
        val = scan.nextLong();
        System.out.print("Enter the index where to add the element: ");
        ind = scan.nextInt();
        list.add(ind, val); //додавання елементу типу long на задану позицію
        System.out.println(list);

    }
}
