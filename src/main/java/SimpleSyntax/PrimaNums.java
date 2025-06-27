package SimpleSyntax;

public class PrimaNums {
    public static void main(String[] args) {
        int count = 0;
        for (int nums = 2; nums <= 100; nums++){
            if (primeNums(nums)){
                count++;
                System.out.println(nums + " is a prime number!");
            }
        }
        System.out.println(count);
    }

    public static boolean primeNums(int nums){
        for (int i = 2; i < nums; i++){
            if (nums % i == 0){
                return false;
            }
        }
        return true;
    }

}














/* public static void main(String[] args) {
        int count = 0;
        for (int n = 2; n <= 100; n++) {
            if (isPrime(n)) {
                System.out.println(n + " is a prime number!");
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isPrime(int n){
        for (int i = 2; i <= n; i++){
            if (n % i == 0 && n != i) {
                return false;
            }
        }
        return true;
    }*/