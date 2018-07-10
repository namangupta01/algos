public class ArrayIntersection2 {

    public static void mergeSort(int arr2[], int start, int end){
        if (start >= end){
            return;
        }
        int mid = (start + end)/2;
        mergeSort(arr2, start, mid);
        mergeSort(arr2, mid+1, end);
        merge(arr2, start, mid, end);
    }

    public static void merge(int arr2[], int start, int mid, int end){
        int []temp = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr2[i] > arr2[j]) {
                temp[k] = arr2[j];
                j++;
                k++;
            } else {
                temp[k] = arr2[i];
                i++;
                k++;
            }
        }

            while(i <= mid){
                temp[k] = arr2[i];
                k++;
                i++;
            }
            while(j <= end){
                temp[k] = arr2[j];
                k++;
                j++;
            }
            for (int l = 0; l < temp.length; l++) {
                arr2[start+l] = temp[l];
            }
    }

    public static boolean binarySearch(int ele, int arr2[], int start, int end){
        if (start <= end){
            int mid = (start + end)/2;
            if (arr2[mid]==ele){
                return true;
            }
            if (arr2[mid] < ele){
                return binarySearch(ele, arr2, mid + 1, end);
            }
            else{
                return binarySearch(ele, arr2, start, mid-1);
            }
        }
        return false;
    }

    public static void intersection(int arr1[], int arr2[]){
        mergeSort(arr2, 0, arr2.length-1);
        for (int i = 0; i < arr1.length; i++) {
            if (binarySearch(arr1[i], arr2, 0, arr2.length-1)){
                System.out.println(arr1[i]);
            }
        }
    }

    public static void main(String[] args) {
        int arr1[] = {2, 6, 8, 5, 4, 3};
        int arr2[] = {2, 7, 4, 3};
        intersection(arr1, arr2);
    }
}
// In this merge algorithm use merge sort + binary search which will make complexity to
//(nlogn + mlogn)
// Only used when elements in arr2 is unique

