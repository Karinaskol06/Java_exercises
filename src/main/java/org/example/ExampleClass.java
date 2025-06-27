package org.example;

public class ExampleClass {
    public static void main(String[] args) {

        //initialization of a two-dimensional array (the second part isn't specified)
        int[][] riders = new int[7][];

        //indices from 0 to 54 are work days and from 5 to 6 - weekends
        riders[0] = new int[10]; //int[10] part specifies the second part of an array (there are 10 rides)
        riders[1] = new int[10];
        riders[2] = new int[10];
        riders[3] = new int[10];
        riders[4] = new int[10];
        riders[5] = new int[2]; //int[2] (there are 2 rides)
        riders[6] = new int[2];
        int i, j;

        //filling the array with data
        for(i=0; i < 5; i++) //from 0 to five as we are filling the first part (work days)
            for(j=0; j < 10; j++)
                riders[i][j] = 2* i + j + 10;

        for(i=5; i < 7; i++) //from 5 to 7 as we are filling weekends
            for(j=0; j < 2; j++)
                riders[i][j] = i + j + 10;

        //outputting the first part of an array
        System.out.println("Riders per trip during the week:");
        for(i=0; i < 5; i++) {
            for(j=0; j < 10; j++)
                System.out.print(riders[i][j] + " ");
            System.out.println();
        }
        System.out.println();

        //outputting the second part
        System.out.println("Riders per trip on the weekend:");
        for(i=5; i < 7; i++) {
            for(j=0; j < 2; j++)
                System.out.print(riders[i][j] + " ");
            System.out.println();
        }


        /*int t, i;
        int[][] table = new int[3][4];
        for(t=0; t < 3; t++) { //iterates through the rows (goes from t = 0 to t = 2)
            for(i=0; i < 4; i++) { //iterates through the columns (goes from i = 0 to i = 3)
                table[t][i] = (t*4)+i+1;
                System.out.print(table[t][i] + " ");
            }
            System.out.println();
        }*/
    }
}
