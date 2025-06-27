package SimpleSyntax;

public class GallonsToLiters {
    public static void main(String[] args) {
        int counter = 0;
        for (int g = 1; g <= 100; g++){
            System.out.println(g + " gallons = " + (g * 3.7854) + " liters!");
            counter++;
            if (counter == 10){
                System.out.println();
                counter = 0;
            }
        }

       // System.out.println("In " + g + " gallons " + "are " + l + " liters!");
    }
}
