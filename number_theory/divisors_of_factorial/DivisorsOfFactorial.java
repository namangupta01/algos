import java.util.Scanner;

public class DivisorsOfFactorial {

    public static boolean [] findPrimeNumbers(int n){
        boolean[] sieve = new boolean[n+1];
        for (int i = 0; i < n + 1; i++) {
            sieve[i] = true;
        }
        sieve[1] = false;
        for (int i = 2; i<= n; i++){
            if (sieve[i] == true){
                for (int j = 2; i*j <=n ;j++){
                    sieve[j*i] = false;
                }
            }
        }
        return sieve;
    }

    public static int findPowerOfPrimeNumber(int p, int n){
        int powerOfPrime = 0;
        for (int i=1; Math.pow(p,i) <= n; i++){
            powerOfPrime += n/Math.pow(p,i);
            powerOfPrime = powerOfPrime%1000000007;
        }
        return powerOfPrime;
    }

    public static long findTotalNumberOfDivisors(int n, boolean[] primeNumberSieve){
        if(n == 1){
            return 1;
        }
        long numberOfDivisors = 1;
        for (int i = 2; i <= n; i++){
            if (primeNumberSieve[i] == true){
                int temp = (findPowerOfPrimeNumber(i, n))%1000000007;
                numberOfDivisors = ((numberOfDivisors)*(temp+1)%1000000007)%1000000007;
            }
        }
        return numberOfDivisors;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean [] primeNumberSieve = findPrimeNumbers(n);
        long ans = findTotalNumberOfDivisors(n, primeNumberSieve);
        System.out.println(ans);
    }
}

/*
    Designed for Input >= 1

    Every number can be expressed in the form of prime numbers such as:
    n = (p^a).(q^b).(r^3).(s^d)............
    and a = n/p^1 + n/p^2 + n/p^3 + n/p^4.......+ n/p^k
    so total divisors of n is (a+1).(b+1).(c+1).(d+1).(e+1).(f+1)......
*/

