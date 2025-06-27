package SimpleSyntax;

public class LabeledBreak {
    public static void main(String[] args) {
        for(int i = 1; i < 4; i++) {
            one: { //label
                two: { //label
                    three: { //label
                        System.out.println("\ni is " + i);
                        if(i==1) break one; //first iteration, i = 1, breaks and moves to the Sys.out
                        // as it is the outer circle
                        if(i==2) break two;
                        if(i==3) break three;
                        // this is never reached
                        System.out.println("won't print");
                    }
                    System.out.println("After block three.");
                }
                System.out.println("After block two.");
            }
            System.out.println("After block one."); //will be displayed 3 times
        }
        System.out.println("After for.");
    }
}
