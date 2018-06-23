public class mergeSort {

    public static void doMergeSort(int a[], int start, int end){
        int mid = (start + end)/2;
        if(start<end){
            doMergeSort(a,start,mid);
            doMergeSort(a, mid+1, end);
            merge(a, start, mid, end);
        }
    }

    public static void merge(int a[], int start, int mid, int end){
        // To perform merging of two sorted array
        int i = start;
        int j = mid + 1;
        int size = end-start+1;
        int b[] = new int[size];
        int k = 0;
        while(i<=mid && j<=end){
            if(a[i]<a[j]){
                b[k] = a[i];
                i++;
                k++;
            }
            else{
                b[k] = a[j];
                j++;
                k++;
            }
        }

        while(i<=mid){
            b[k] = a[i];
            i++;
            k++;
        }
        while(j<=end){
            b[k] = a[j];
            j++;
            k++;
        }
        for (int l = 0; l < size; l++) {
            a[start+l] = b[l];
        }
    }

    public static void main(String args[]){
        int a[] = {10, 23, 0, 50, 12, 99, 56, 2, 1, 11};
        System.out.println("Unsorted Array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        doMergeSort(a, 0, a.length-1);
        System.out.println("Sorted Array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
