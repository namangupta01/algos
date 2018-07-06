import java.util.Scanner;

public class CalculatePower {
    
    public static long calc(int x, int n){
        if ( n == 0 ){
            return 1;
        }
        return x * calc(x, n-1);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number");
        int x = scanner.nextInt();
        System.out.println("Enter power");
        int n = scanner.nextInt();
        System.out.println(calc(x, n));
    }
}

