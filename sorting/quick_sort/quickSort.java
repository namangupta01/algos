public class quickSort {

    public static void doQuickSort(int a[], int start, int end){
        if(start >= end){
            return ;
        }
        int pivot = a[end];
        int j = start;
        for (int i = start; i < end; i++) {
            if(a[i] < pivot){
                int temp = a[i];
                a[i] = a[j];
                a[j]= temp;
                j++;
            }
        }
        int temp = a[end];
        a[end] = a[j];
        a[j] = temp;
        doQuickSort(a, start, j-1);
        doQuickSort(a, j+1, end);
    }

    public static void main(String[] args) {
        int a[] = {10, 23, 0, 50, 12, 99, 56, 2, 1, 11};
        System.out.println("Unsorted Array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        doQuickSort(a, 0, a.length-1);
        System.out.println("Sorted Array using QuickSort: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
