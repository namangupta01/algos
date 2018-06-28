import java.util.Scanner;

public class PrimeNumbersFrom1ToN {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= i/2; j++) {
                if (i%j==0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime == true){
                count++;
            }
        }
        System.out.println(count);
    }
}
// Complexity is O(N^2)