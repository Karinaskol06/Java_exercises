package SimpleSyntax;
import java.util.Scanner;
public class PhoneBook {
    public static void main(String[] args) {
        String[][] phoneBook = {
                { "Karina" , "+380992015889"},
                { "Nataliia", "+380666100604"},
                { "Artur", "+4802911938"},
                { "Valentina", "+38066205785"}
        };
        String searchName;
        System.out.print("Enter search name: ");
        Scanner sc = new Scanner(System.in);
        searchName = sc.nextLine();

        for (String[] n : phoneBook){
            if (n[0].equals(searchName)){
                System.out.println(n[1]);
            }
            /*for (String name : n){
                if (name.equals(searchName)){
                    System.out.print("Phone number: " + n[1] + "\n");
                }
            }*/
        }
    }
}
