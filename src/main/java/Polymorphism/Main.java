package Polymorphism;

public class Main {
    public static void main(String[] args) {
        Noodle spaghetti, ramen, pho;

        spaghetti = new Spaghetti();
        ramen = new Ramen();
        pho = new Pho();

        // Add your code below:
        Noodle[] allTheNoodles = {spaghetti, ramen, pho};

        for (Noodle noodle : allTheNoodles){
            System.out.println(noodle.getCookPrep());
        }

        System.out.println();
        NoodleRestaurant customer = new NoodleRestaurant("Karina");
        customer.order(spaghetti);
    }
}