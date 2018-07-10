public class PairSumArray1 {

    public static void findpairs(int []arr, int sum){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum){
                    System.out.println(Math.min(arr[i], arr[j])+ " " + Math.max(arr[i], arr[j]));
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 6, 8, 5, 4, 3, 0, 2, 2};
        int sum = 4;
        findpairs(arr, sum);
    }
}

// This solution of finding the pair of numbers in array having their sum 
// equal to sum is O(n^2)