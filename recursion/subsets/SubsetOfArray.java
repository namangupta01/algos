public class SubsetOfArray {
    public static int[][] subsets(int input[]) {
        if(input.length == 1){
            int[][] ans = new int[2][0];
            ans[1] = new int[1];
            ans[1][0] = input[0];
            return ans;
        }
        int[] smallInput = new int[input.length-1];
        for (int i = 0; i < smallInput.length; i++) {
            smallInput[i] = input[i+1];
        }
        int smallAns[][] = subsets(smallInput);
        int [][]ans = new int[smallAns.length*2][];

        int k = 0;

        for (int i = 0; i < smallAns.length; i++) {
            ans[k] = new int[smallAns[i].length];
            for (int j = 0; j < smallAns[i].length; j++) {
                if (smallAns[i].length == 0){
                    ans[k] = smallAns[i];
                }
                else{
                    ans[k][j] = smallAns[i][j];
                }

            }
            k++;
        }

        for (int i = 0; i < smallAns.length; i++) {
            ans[k] = new int[smallAns[i].length+1];
            ans[k][0] = input[0];
            for (int j = 0; j < smallAns[i].length; j++) {
                if (smallAns[i].length!=0){
                    ans[k][j+1] = smallAns[i][j];
                }
            }
            k++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] input = {4, 2};
        int [][]ans = subsets(input);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }
}

