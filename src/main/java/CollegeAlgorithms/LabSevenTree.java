package CollegeAlgorithms;

import java.util.Scanner;

class BinaryTree {
    static class Node {
        char letter; // буква дерева
        Node leftChild, rightChild; // посилання на лівий і правий вузол дерева

        Node(char val) {
            letter = val;
            leftChild = rightChild = null;
        }
    }

    Node root; // створення кореня дерева типу Node

    // Метод додавання елемента
    public void insert(char val) {
        root = insertRecursive(root, val);
        // рекурсія дозволяє пройти дерево до місця вставки
    }

    private Node insertRecursive(Node node, char val) {
        if (node == null) {
            return new Node(val); // створення нового вузла якщо його немає
        }
        // якщо значення менше за корінь, то вставляємо зліва,
        // в іншому випадку - справа
        if (val < node.letter) {
            node.leftChild = insertRecursive(node.leftChild, val);
        } else if (val > node.letter) {
            node.rightChild = insertRecursive(node.rightChild, val);
        }
        return node;
    }

    // Метод для графічного відображення дерева
    public void displayTree() {
        System.out.println("Displaying the tree: ");
        printCharTree(root, 0, "Root: ");
        System.out.println();
    }

    private void printCharTree(Node node, int level, String prefix) {
        if (node == null) return; // Якщо вузол порожній, нічого не виводимо

        System.out.println(" ".repeat(level * 4) + prefix + node.letter); // Виводимо вузол
        printCharTree(node.leftChild, level + 1, "L--> "); // Відображення лівого піддерева
        printCharTree(node.rightChild, level + 1, "R--> "); // Відображення правого піддерева
    }

    // Пошук мінімального значення
    private char findMin(Node node) {
        while (node.leftChild != null) {
            node = node.leftChild;
        }
        return node.letter;
    }

    // Видалення елемента з дерева
    public void delete(char value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node node, char value) {
        if (node == null) {
            System.out.println("Element not found.");
            return null;
        }

        if (value < node.letter) {
            node.leftChild = deleteRecursive(node.leftChild, value);
        } else if (value > node.letter) {
            node.rightChild = deleteRecursive(node.rightChild, value);
        } else {
            // Вузол знайдено
            // Вузол без дітей або з одним дочірнім
            if (node.leftChild == null) {
                return node.rightChild;
            } else if (node.rightChild == null) {
                return node.leftChild;
            }

            // Вузол із двома дочірніми
            node.letter = findMin(node.rightChild); // Мінімальне значення в правому піддереві
            node.rightChild = deleteRecursive(node.rightChild, node.letter);
        }
        return node;
    }
}

public class LabSevenTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree tree = new BinaryTree(); // Виправлено ім'я класу

        // Введення елементів дерева
        System.out.println("Введіть кількість елементів для побудови дерева:");
        int n = scanner.nextInt();
        System.out.println("Введіть елементи дерева:");
        for (int i = 0; i < n; i++) {
            char value = scanner.next().charAt(0);
            tree.insert(value);
        }

        // Відображення дерева
        System.out.println("\nВивід бінарного дерева:");
        tree.displayTree();

        // Вставка нового елемента
        System.out.println("Введіть елемент для вставки:");
        char insertValue = scanner.next().charAt(0);
        tree.insert(insertValue);
        tree.displayTree();

        // Видалення елемента
        System.out.println("Введіть елемент для видалення:");
        char deleteValue = scanner.next().charAt(0);
        tree.delete(deleteValue);
        tree.displayTree();

        scanner.close();
    }
}
