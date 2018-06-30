import java.util.Scanner;

public class EuclidAlgorithmGCD {

    public static int findGCD(int a, int b){
        if(a<b){
            return findGCD(b,a);
        }
        if (b==0){
            return a;
        }
        return findGCD(b, a%b);
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
/*
   Complexity is O(log(max(a,b)))

   Explanation:
    Euclid Algorithm is used to find GCD of two numbers.
    Its has a time complexity of O(log(max(a,b)))
    It is very efficient in camparsion to the traditional method which have time
    complexity of O(min(a,b)).

    According to Euclid's Theorem:
     gcd(a,b) = gcd(b, a%b)

    Using above theorem:
        Let r = a%b
        Then, 0 <= r < b
        And we can also say, r = a%b = a - b*[a/b] where [] is the floor value
        Now for maximum value of (a - b*[a/b]), we have to find the minimum value
        of [a/b] which is equal to 1. So now,
        r <= a-b.

        Adding r<b and r<=a-b,
        we get 2r < a
        so, r < a/2

        Now, According to the theorem:
        gcd(a, b) = gcd (b, a%b)
        let r = a % b
        I so, gcd(a, b) = gcd(b ,r)
        II and gcd(b, r) = gcd(r, r%b)

        So we can say that after two steps problem of a is reduced to problem
        less than a/2. This problem will continue till ---> 1,

        So, a/(2^k) = 1
        2^k = a
        klog2 = log a
        k = log(a)
        So in 2*k steps problem of a will be reduced to 1.So complexity is:
        O(2*log(max(a,b))) = O(log(max(a,b)))
 */
