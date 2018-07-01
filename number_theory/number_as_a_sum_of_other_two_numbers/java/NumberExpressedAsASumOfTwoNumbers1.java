import java.util.Scanner;

public class NumberExpressedAsASumOfTwoNumbers1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int d = scanner.nextInt();
        int count = 0;
        for (int i = 0; i <= d/b; i++) {
                if ((d - b*i)%a == 0){
                    System.out.println(a + "*" + (d - b*i)/a + " + " + b + " * " + i + " = " + d);
                    count++;
            }
        }
        System.out.println("Total ways are : "+ count);
    }
}

/*
    Here, we are finding the ways for every x and y >=0 which satisfies the above equation
    a*x + b*y = d

    This is the improved part of previous version Algorithm:
    Here, a*x + b*y = d
    x <= d/a and y <= d/b
    so, a*x = d - b*y
    So for each value of y there exist one value of x so we can find value of y and then
    there will be corresponding value of x indirectly.

    ===> So we check for any value of y, (d-b*y)%a = 0 then y is the value we want and there
         will be corresponding value of x and vice versa.

    Complexity of this solution is O([d/b]) or O([d/a]) which is approximately equal to :
    O(d/b) or O(d/a)

 */
