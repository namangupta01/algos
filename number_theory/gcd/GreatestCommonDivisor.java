import java.util.Scanner;

public class GreatestCommonDivisor {

    public static int findGCD(int n1, int n2){
        int max = Math.max(n1, n2);
        int min = Math.min(n1, n2);
        int gcd = 1;
        if (max%min == 0){
            return min;
        }
        for (int i = 2; i <= min/2 ; i++) {
            if ((max % i == 0) && (min % i == 0)){
                gcd = i;
            }
        }
        return gcd;
    }

    public static void main(String[] args) {
        System.out.println("Enter two numbers:");
        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        int gcd = findGCD(n1, n2);
        System.out.println(gcd);
    }
}
