package ObjectsMethods;

class Car{
    int mpg;
    int passengers;
    int fuelcap;

    Car(int m, int p, int f){
        mpg = m;
        passengers = p;
        fuelcap = f;
    }

    double fuelNeeded (int miles){
        return (double) miles / mpg;
    }
}

public class CarObjMethods {
    public static void main(String[] args) {
        Car KiaSportage = new Car(12, 5, 14); //here are constructor names
        Car Bentley = new Car(21, 3, 16);
        double gallons;
        int distance = 252;


        gallons = KiaSportage.fuelNeeded(distance);
        System.out.println("For Kia Sportage: " + gallons + " for " + KiaSportage.passengers + " people");
        gallons = Bentley.fuelNeeded(distance);
        System.out.println("For Bentley: " + gallons);
    }
}

