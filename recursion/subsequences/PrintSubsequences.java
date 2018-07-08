import java.util.Scanner;

public class PrintSubsequences {

    public static void printSubsequences(String input, String outputSequence){
        if (input.length() == 0){
            System.out.println(outputSequence);
            return;
        }
        printSubsequences(input.substring(1), outputSequence);
        printSubsequences(input.substring(1), outputSequence + input.charAt(0));
    }

    public static void main(String[] args) {
        System.out.println("Enter the string :");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        printSubsequences(input, "");
    }
}
