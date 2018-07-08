import java.util.Scanner;

public class PrintSubsetSumToK {

    public static void printSubsetsSumTok(int input[], int k, int [] outputSet){
        if (input.length == 0){
            int sum = 0;
            for (int i = 0; i < outputSet.length; i++) {
                sum+= outputSet[i];
            }
            if (k == sum){
                for (int i = 0; i < outputSet.length; i++) {
                    System.out.print(outputSet[i] + " ");
                }
                System.out.println();
            }
            return;
        }

        int [] smallInput = new int[input.length-1];
        for (int i = 0; i < smallInput.length; i++) {
            smallInput[i] = input[i+1];
        }
        printSubsetsSumTok(smallInput, k, outputSet);
        int [] newOutputSet = new int[outputSet.length+1];
        for (int i = 0; i < newOutputSet.length-1; i++) {
            newOutputSet[i] = outputSet[i];
        }
        newOutputSet[newOutputSet.length-1] = input[0];
        printSubsetsSumTok(smallInput, k, newOutputSet);
    }

    public static void printSubsetsSumTok(int input[], int k) {
        int [] outputSets = new int [0];
        printSubsetsSumTok(input, k, outputSets);

    }

    public static void main(String[] args) {
        System.out.println("Enter the number of elements of arrays : ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] input = new int[n];
        System.out.println("Enter the array elements : ");
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println("Enter the number whose sum set is to be found : ");
        int k = scanner.nextInt();
        printSubsetsSumTok(input, k);
    }
}
