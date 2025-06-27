package SimpleSyntax;

public class LetterGuess {
    public static void main(String[] args)
        throws java.io.IOException{
            char ans = 'K', guess;
            System.out.print("Enter a letter between A and Z: ");
            guess = (char) System.in.read();
            System.out.println("Your letter is: " + guess);

            if (guess == ans){
                System.out.println("You guessed correctly!");
            } else{
                System.out.print("Try one more time. You're too ");
                if (guess < ans) System.out.print("low.");
                else System.out.print("high.");
            }

        }
}
