package CollegeAlgorithms;

import java.util.Scanner;

public class Lab8TreeTraverse {
    static int tabs = 0; // для відступів при виведенні

    static class Branch {
        char letter;
        Branch leftChild, rightChild;

        Branch(char letter) {
            this.letter = letter;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    // додавання елементу до дерева
    public static void add(char let, Branch branch) {
        if (let < branch.letter) { // перевірити ліве піддерево
            if (branch.leftChild == null) {
                branch.leftChild = new Branch(let);
            } else {
                add(let, branch.leftChild);
            }
        } else if (let > branch.letter) { // перевірити праве піддерево
            if (branch.rightChild == null) {
                branch.rightChild = new Branch(let);
            } else {
                add(let, branch.rightChild);
            }
        }
    }

    // видалення елементу з дерева
    public static Branch delete(char let, Branch branch) {
        if (branch == null) return null;

        if (let < branch.letter) { // пошук в лівому піддереві
            branch.leftChild = delete(let, branch.leftChild);
        } else if (let > branch.letter) { // пошук в правому піддереві
            branch.rightChild = delete(let, branch.rightChild);
        } else {
            if (branch.leftChild == null && branch.rightChild == null) {
                // вузол є листком
                return null;
            } else if (branch.leftChild == null) {
                // вузол має тільки праве піддерево
                return branch.rightChild;
            } else if (branch.rightChild == null) {
                // вузол має тільки ліве піддерево
                return branch.leftChild;
            } else {
                // вузол має два піддерева
                char minValue = findMin(branch.rightChild);
                branch.letter = minValue;
                branch.rightChild = delete(minValue, branch.rightChild);
            }
        }
        return branch;
    }

    // знайти мінімальне значення
    public static char findMin(Branch branch) {
        while (branch.leftChild != null) {
            branch = branch.leftChild;
        }
        return branch.letter;
    }

    // обхід дерева низхідним шляхом
    public static void descendTraversal(Branch branch) {
        if (branch == null) return;
        System.out.print(branch.letter + " "); // друк поточного вузла (корінь)
        descendTraversal(branch.leftChild);   // обхід лівого піддерева
        descendTraversal(branch.rightChild);  // обхід правого піддерева
    }

    // виведення дерева
    public static void printTree(Branch branch) {
        if (branch == null) return;
        tabs += 5;
        printTree(branch.rightChild); // проходження правого піддерева

        for (int i = 0; i < tabs; i++) System.out.print(" ");
        System.out.println(branch.letter);

        printTree(branch.leftChild); // проходження лівого піддерева
        tabs -= 5;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Branch tree = null;
        char[] letters = {'M', 'F', 'A', 'T', 'K', 'H', 'L', 'P', 'S', 'L'};
        for (char l : letters) {
            if (tree == null) {
                tree = new Branch(l);
            } else {
                add(l, tree);
            }
        }

        System.out.println("\nВиведення дерева:");
        printTree(tree);

        System.out.println("\nОбхід дерева низхідним шляхом:");
        descendTraversal(tree); // виклик низхідного обходу
        System.out.println();

        char deleteLetter;
        System.out.println("Введіть літеру для видалення: ");
        deleteLetter = sc.next().charAt(0);
        tree = delete(deleteLetter, tree);
        printTree(tree);

        System.out.println("\nОбхід дерева низхідним шляхом після видалення:");
        descendTraversal(tree);
        System.out.println();

        char newLetter;
        System.out.println("Введіть літеру для додавання: ");
        newLetter = sc.next().charAt(0);
        add(newLetter, tree);
        printTree(tree);

        System.out.println("\nОбхід дерева низхідним шляхом після додавання:");
        descendTraversal(tree);
        System.out.println();
    }
}
