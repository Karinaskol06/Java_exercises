package SimpleSyntax;

public class JavaSyntax {
    public static void main(String[] args)
        throws java.io.IOException {
        char choice, ignoreVar, cont = '+';
        do{
            do {
                System.out.println("1 - if");
                System.out.println("2 - for");
                System.out.println("3 - while");
                System.out.println("4 - switch");
                System.out.println("5 - do-while");
                System.out.print("\nEnter your choice (number): ");
                choice = (char) System.in.read();
                do {
                    ignoreVar = (char) System.in.read();
                } while (ignoreVar != '\n');
            } while (choice < '1' || choice > '5');

            switch(choice){
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
            System.out.print("\nDo you want to continue? \nPress + or -");
            cont = (char) System.in.read();
        } while (cont == '+');
        if (cont != '+'){
            System.out.println("\nEnd of the program");
        }
    }
    }
