import java.util.Scanner;

public class ExtendedEuclid {

    public static Triplet getExtendedEuclid(int a, int b){
        if  (a<b){
            return getExtendedEuclid(b, a);
        }

        if( b == 0){
            Triplet ans = new Triplet();
            ans.gcd = a;
            ans.x = 1;
            ans.y = 0;
            return ans;
        }
        Triplet ans = getExtendedEuclid(b, a%b);

        Triplet myAns = new Triplet();
        myAns.gcd = ans.gcd;
        myAns.x = ans.y;        // Using formaula x = y1
        myAns.y = (ans.x - (a/b)*ans.y); // Using formula: y = x1 - [a/b]*y1

        return  myAns;
    }

    public static void main(String[] args) {
        System.out.println("Enter two numbers:");
        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();
        Triplet myAns = getExtendedEuclid(n1, n2);
        System.out.println("Greatest Common Divisor is :" + myAns.gcd);
        System.out.println("Equation is :" + n1 + "*" + myAns.x + " + " + n2 + "*" + myAns.y + " = "+ myAns.gcd);
    }
}

/*
    In Extended Euclid we find the value of x and y such that,
    => (a*x + b*y) = gcd(a, b)
    We know, gcd(a, b) = gcd(b , a%b)
    So, ( b*x1 + (a%b)*y1 ) = gcd(b, a%b) = gcd(a, b) = (a*x + b*y)
    ==> (a*x + b*y) = ( b*x1 + (a%b)*y1 )-------(1)
    Now, a%b = a - [a/b]*b where [] is the flooring value ------(2)

    By putting 2 in 1 we get ,
    (a*x + b*y) = ( b*x1 + (a - [a/b]*b)*y1 )
    (a*x + b*y) = ( a*y1 + b(x1-[a/b]*y1) )
    So on comparing for coefficient of a and b we get,
    ------------------------
    |      x = y1          |
    |  y = (x1 - [a/b]*y1) |
    ------------------------
    Where x and y belongs to gcd(a, b)
    and x1 and y1 belongs to gcd(b, (a%b))

 */
