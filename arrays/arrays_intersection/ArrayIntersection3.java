public class ArrayIntersection3 {
    public static void mergeSort(int arr[], int start, int end){
        if (start <  end){
            int mid = (start + end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, end);
        }
    }

    public static void merge(int arr[], int start, int end){
        int mid = (start + end)/2;
        int i = start;
        int j =mid+1;
        int k = 0;
        int [] temp = new int[end-start+1];
        while (i<=mid && j <= end){
            if (arr[i]<arr[j]){
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
            arr[l+start] = temp[l];
        }
    }


    public static void findIntersections(int [] arr1, int arr2[]){
        int i =0;
        int j = 0;
        while(i<= arr1.length-1 && j <= arr2.length-1){
            if (arr1[i] == arr2[j]){
                System.out.println(arr1[i]);
                i++;
                j++;
            }
            else if(arr1[i] < arr2[j]){
                i++;
            }
            else{
                j++;
            }
        }
    }


    public static void main(String[] args) {
        int arr1[] = {2, 6, 8, 5, 4, 3};
        int arr2[] = {2, 7, 4, 3};
        mergeSort(arr1, 0, arr1.length-1);
        mergeSort(arr2, 0, arr2.length-1);
        findIntersections(arr1, arr2);
    }
}

// This method is used to find the intersection of two arrays in :
// Time complexity of : O(nlon) + O(mlogm) + O(m+n)
// In this algo, two arrays are sorted using mergesort and
// compared using merge algo which is also used by merge sort to merge two arrays