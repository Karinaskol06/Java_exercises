package SimpleSyntax;

public class LetterGuessing {
    public static void main(String[] args)
        throws java.io.IOException {
            char guess, letter = 'Y';
            do {
                System.out.print("Enter your guess: ");
                guess = (char) System.in.read();
                System.in.read();
            } while (guess != letter);
            System.out.println("You guessed it!");
        }
    }

