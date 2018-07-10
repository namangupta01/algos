public class PairSumInArray2 {

    public static void mergeSort(int arr[], int start, int end){
        if (start < end){
            int mid = (start + end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, end);
        }
    }

    public static void merge(int arr[], int start, int end){
        int mid = (start + end)/2;
        int i = start;
        int j = mid+1;
        int k = 0;
        int temp[] = new int[end-start+1];
        while (i<=mid && j<=end){
            if (arr[i] < arr[j] ){
                temp[k] = arr[i];
                i++;
                k++;
            }
            else{
                temp[k] = arr[j];
                j++;
                k++;
            }
        }

        while (i<=mid){
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j<=end){
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (int l = 0; l < temp.length; l++) {
            arr[start+l] = temp[l];
        }
    }

    public static void findPairs(int arr[], int num){
        int i = 0;
        int j = arr.length-1;
        while (i<j){
            int sum = arr[i] + arr[j];
            if (sum == num){
                int count = 1;
                int k = j-1;
                while(i < k){
                    if (arr[k] == arr[j]){
                        count++;
                        k--;
                    }
                    else{
                        break;
                    }
                }
                for (int l = 1; l <= count; l++) {
                    System.out.println(Math.min(arr[i], arr[j])+ " " + Math.max(arr[i], arr[j]));
                }
                i++;
            }
            else if(sum < num){
                i++;
            }
            else{
                j--;
            }
        }
    }


    public static void main(String[] args) {
        int arr[] = {2, 6, 8, 5, 4, 3, 0, 2, 2, 1};
        int num = 4;
        mergeSort(arr, 0, arr.length-1);
        findPairs(arr, num);
    }
}
// This method can also be used to find pairs in array whose sum is a given number
// Complexity is O(nlog(n)) + O(n^2)
