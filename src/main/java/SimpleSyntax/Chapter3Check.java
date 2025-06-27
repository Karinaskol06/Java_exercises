package SimpleSyntax;
public class Chapter3Check {
    public static void main(String[] args)
        throws java.io.IOException {
        System.out.print("Enter the characters or the dot to stop: ");

        while(true){
            char ch = (char) System.in.read();
            if (ch == '.') break;
            else if (ch >= 'a' && ch <= 'z') ch = (char) (ch - 32);
            else if (ch >= 'A' && ch <= 'Z') ch = (char) (ch + 32);
            System.out.print(ch);
        }
    }
}

