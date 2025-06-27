package SimpleSyntax;

public class DotProgram {
    public static void main(String[] args)
        throws java.io.IOException{
        int count = 0;
            for (;;){
                char ch;
                ch = (char) System.in.read();
                if (ch == '.') break;
                else if (ch == ' ') count++;
            }
        System.out.print(count);
        }
    }
