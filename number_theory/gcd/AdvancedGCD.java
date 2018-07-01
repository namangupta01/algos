import java.util.Scanner;

public class AdvancedGCD {

    public static int FindModulo(int a, String s){
        if(s.length() <= 1){
            return (s.charAt(0) - 48) ;
        }
        int ans = ((FindModulo(a, s.substring(0, s.length()-1))*10) % a + ((int)s.charAt(s.length()-1)-48) % a)%a;
        return ans;
    }

    public static int FindGCD(int a, int b){
        if(b == 0){
            return a;
        }

        return FindGCD(b, a%b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String b = scanner.next();
        int modulo = FindModulo(a, b);
        int ans = FindGCD(a, modulo);
        System.out.println(ans);
    }
}

/*


Advanced GCD algo si used to find the GCD of numbers whose one number is out of
the range of int and long and other number is in the range

We find b%a where b is large number and stored in string and a is smaller number
we use concept : let a bog number n, then
    n%a = ((n/10)*10 + n%10)%a == (((n/10)*10)%a + (n%10)%a)%a
    n/10 ====> ((n/100)*10)%a + (((n/10)%10)%a)%a
    and so on....
After finding n%a use Euclid algo to find the GCD
================================
Complexity is O(b) + O(log(a))
==============================
 */
