package CollegeAlgorithms;

import java.util.LinkedList;

// Структура для зберігання інформації про людину
class note {
    String NAME;
    String TEL;
    String BDAY;

    public note(String NAME, String TEL, String BDAY) {
        this.NAME = NAME;
        this.TEL = TEL;
        this.BDAY = BDAY;
    }

    // Виведення інформації
    @Override
    public String toString() {
        return "Name: " + NAME + ", Tel: " + TEL + ", Bday: " + BDAY;
    }
}

// Хеш-таблиця
class HashTable {
    private final LinkedList<note>[] table;
    private final int size;

    public HashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Метод для обчислення індексу
    private int hash(String key) {
        return Math.abs(key.hashCode() % size); // Використання Math.abs для уникнення негативних значень
    }

    // Метод для додавання
    public void insert(note note) {
        int index = hash(note.NAME);
        table[index].add(note);
    }

    // Пошук за ім'ям
    public note search(String name) {
        int index = hash(name);
        for (note note : table[index]) {
            if (note.NAME.equals(name)) {
                return note;
            }
        }
        return null;
    }

    // Видалення запису
    public void delete(String name) {
        int index = hash(name);
        table[index].removeIf(note -> note.NAME.equals(name));
    }

    // Виведення записів
    public void display() {
        for (int i = 0; i < size; i++) {
            if (!table[i].isEmpty()) {
                for (note note : table[i]) {
                    System.out.println(note);
                }
            }
        }
    }
}

public class HashTableLab11 {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10); // Створення хеш-таблиці

        // Ініціалізація
        hashTable.insert(new note("Сколібог Каріна", "3809947271", "01-12-2006"));
        hashTable.insert(new note("Танасов Артем", "38066381387", "13-11-2006"));
        hashTable.insert(new note("Радомська Анна", "3809573873", "13-11-2006"));

        System.out.println("Всі записи в хеш-таблиці:");
        hashTable.display();

        String searchName = "Сколібог Каріна";
        note note = hashTable.search(searchName);
        if (note != null) {
            System.out.println("\nЗнайдений запис для " + searchName + ": \n" + note);
        } else {
            System.out.println("\nЗапис для " + searchName + " не знайдено.");
        }

        String deleteName = "Радомська Анна";
        hashTable.delete(deleteName);
        System.out.println("\nПісля видалення запису для " + deleteName + ":");
        hashTable.display();
    }
}
