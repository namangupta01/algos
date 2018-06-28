import java.util.Scanner;

public class PrimeNumbersFrom1ToNImproved {
    public static boolean checkPrime(int n){
        int count = 0;
        for (int i = 1; i*i <= n; i++) {
            if(n % i == 0){
                if(i*i==n){
                    count += 1;
                }
                else{
                    count += 2;
                }
            }
        }
        if (count == 2){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count  = 0;
        for (int i = 1; i <= n; i++) {
            if(checkPrime(i)){
                count++;
            }
        }
        System.out.println(count);
    }
}

// Complexcity of this also is O(N^3/2)
