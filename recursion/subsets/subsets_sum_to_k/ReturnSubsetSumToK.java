import java.util.Scanner;

public class ReturnSubsetSumToK {

    public static int[][] subsets(int input[]){
        if (input.length == 0){
            int[][] outputSet = new int[1][0];
            return outputSet;
        }

        int [] smallInput = new int[input.length-1];
        for (int i = 0; i < smallInput.length; i++) {
            smallInput[i] = input[i+1];
        }
        int [][] smallOutput = subsets(smallInput);

        int [][] ans = new int[smallOutput.length*2][];
        int k = 0;
        for (int i = 0; i < smallOutput.length; i++) {
            ans[i] = new int[smallOutput[i].length];
            for (int j = 0; j < smallOutput[i].length; j++) {
                ans[i][j] = smallOutput[i][j];
            }
            k++;
        }

        for (int i = 0; i < smallOutput.length; i++) {
            ans[k] = new int[smallOutput[i].length+1];
            ans[k][0] = input[0];
            for (int j = 1; j <= smallOutput[i].length; j++) {
                ans[k][j] = smallOutput[i][j-1];
            }
            k++;
        }
        return ans;
    }

    public static int[][] subsetsSumK(int input[], int k) {
        int output[][] = subsets(input);
        int count = 0;
        boolean[] sieve = new boolean[output.length];
        for (int i = 0; i < output.length; i++) {
            int sum = 0;
            for (int j = 0; j < output[i].length; j++) {
                sum += output[i][j];
            }
            if (sum == k){
                count++;
                sieve[i] = true;
            }
        }

        int [][] finalAnswer = new int[count][];
        int m = 0;
        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i] == true){
                finalAnswer[m] = new int[output[i].length];
                for (int j = 0; j < finalAnswer[m].length; j++) {
                    finalAnswer[m][j] = output[i][j];
                }
                m++;
            }
        }
        return finalAnswer;
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of elements in array: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int input[] = new int[n];
        System.out.println("Enter the elements to be found :");
        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println("Enter the number whose sum set is to be found: ");
        int k = scanner.nextInt();
        int [][] ans = subsetsSumK(input, k);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] +  " ");
            }
            System.out.println();
        }
    }
}
