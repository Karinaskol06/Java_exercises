package ObjectsMethods;

import java.io.IOException;

class Methods {
    void helpOn(char choice) {
        switch (choice) {
            case '1':
                System.out.println("The if: \n");
                System.out.println("if(condition) statement;");
                System.out.println("else statement;");
                break;
            case '2':
                System.out.println("The for: \n");
                System.out.println("for(init; condition; iteration)");
                System.out.println("statement");
                break;
            case '3':
                System.out.println("The while: \n");
                System.out.println("while(condition) statement;");
                break;
            case '4':
                System.out.println("The switch: \n");
                System.out.println("\"switch(expression) {\")");
                System.out.println(" case constant:");
                System.out.println(" statement sequence");
                break;
            case '5':
                System.out.println("The do-while: \n");
                System.out.println("do {");
                System.out.println(" statement;");
                System.out.println("} while (condition);");
                break;
        }
    }


    void showMenu() {
        System.out.println("\n1 - if");
        System.out.println("2 - for");
        System.out.println("3 - while");
        System.out.println("4 - switch");
        System.out.println("5 - do-while");
        System.out.println("If you want to exit press - ");
    }

    boolean isValid(char choice) {
        return (choice >= '1' && choice <= '5') || choice == '-';
    }
}

    public class JavaHelper {
        public static void main(String[] args)
                throws IOException {
            char choice;
            Methods obj = new Methods();

            System.out.print("\nWelcome to the java helper menu!");
            do {
                obj.showMenu();
                choice = (char) System.in.read();
                while (System.in.read() != '\n') ;
                if (obj.isValid(choice)) {
                    if (choice == '-') break;
                    obj.helpOn(choice);
                } else {
                    System.out.println("Invalid choice. Try again.");
                }
            } while (true);
        }
    }
