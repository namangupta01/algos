import java.util.Scanner;

public class NumberExpressedAsASumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int d = scanner.nextInt();
        int count = 0;
        for (int i = 0; i <= d/a; i++) {
            for (int j = 0; j <= d/b ; j++) {
                if ((a*i + b*j) == d){
                    System.out.println(a + "*" + i + " + " + b + " * " + j + " = " + d);
                    count++;
                }
            }
        }
        System.out.println("Total ways are : "+ count);
    }
}

/*
    Here, we are finding the ways for every x and y >=0 which satisfies the above equation
    a*x + b*y = d

    Complexity of this solution is O([d/a]*[d/b]) which is approximately equal to :
    O(d^2/ab)
 */
