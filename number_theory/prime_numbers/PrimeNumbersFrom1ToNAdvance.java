import java.util.Scanner;

public class PrimeNumbersFrom1ToNAdvance {

    // This approach of finding prime numbers is called Sieve Of Eratosthenes
    public static int sieveOfEratosthenes(int n){
        boolean prime[] = new boolean[n+1];  // Sieve is an array with values
        // Initialize with initial values
        prime[1] = false;
        for (int i = 2; i <=n; i++) {
            prime[i] = true;
        }
        for (int i=2; i*i<=n; i++){
            if (prime[i]==true){
                for (int j = i; i*j <= n; j++) {
                    prime[i*j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 1; i <= n ; i++) {
            if (prime[i]==true){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count  = sieveOfEratosthenes(n);
        System.out.println(count);
    }
}

//Complexity:
//Approximately: n(1/2 + 1/3 + 1/4 + 1/5 + 1/6 + 1/7 + ........ + 1/(n^1/2))
//which is equal to n(log log n^1/2) and complexity is equal to O(nlog(log n^1/2))
// which can be equal to O(nlog(log n))


//    Steps:
//    1. Make an array a of size N+1 of boolean type
//    2. Initialize 0th and 1th index with false and rest by true
//    3. Loop from i = 0 to (n^1/2)
//        ----Mark all multiple of i starting from i*i as false;
//    4. You have an array of prime numbers with true value
