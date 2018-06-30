import java.util.Scanner;

public class MultiplicativeModuloInverse {

    public static Triplet getMultiplicativeModuloInverse(int a, int m){
        if (m ==0 ){
            Triplet myAns = new Triplet();
            myAns.gcd = a;
            myAns.x = 1;
            myAns.y = 0;
            return myAns;
        }

        Triplet ans = getMultiplicativeModuloInverse(m ,a%m);
        Triplet myAns = new Triplet();
        myAns.gcd = ans.gcd;
        myAns.x = ans.y;
        myAns.y = ans.x - (a/m)*ans.y;
        return myAns;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two numbers whose multiplicative inverse is to be found: ");
        int a = scan.nextInt();
        int m = scan.nextInt();
        Triplet ans = getMultiplicativeModuloInverse(a, m);
        if (ans.gcd == 1){
            System.out.println("Multiplicative Inverse Exist and it is :" + ans.x);
        }
        else{
            System.out.println("Multiplicative Inverse Don't Exist ");
        }
    }
}

/*
    Multiplicative modulo inverse of a, m is a number which satisfy the equation
    (a.b)%m = 1 then b is said to be the multiplicative inverse of a, m.

    According to Extended Euclid's Algorithm :
    x = y1
    y = x1 - [a/b]*y1 where[.] is the flooring value

    So, lets suppose multiplicative inverse of a, m exists and is equal to b.
    so we can say a.b is in the form of mq + 1 i.e
    a.b = m.q + 1
    a.b - m.q = 1
    a.b + m.Q = 1 ====> This is similar to somewhat like a.b + m.q = gcd(a,m) = 1

    ---------------------------
    | a.b + m.q = gcd(a,m) = 1 |
    ---------------------------

    So, multiplicative inverse of a, m will only exist if they are co-prime
    i.e of their gcd is 1. And if they are co-prime their multiplicative inverse
    will be x part of the equation: a.x + m.y = gcd(a, m)

 */
