import java.util.Scanner;

public class FibonacciNumber {

    public static int number(int n){
        if (n == 1){
            return 0;
        }
        else if(n == 2){
            return 1;
        }
        return number(n-1) + number(n-2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number to which you want to print the series");
        int n = scanner.nextInt();
        System.out.println(number(n));
    }
}
