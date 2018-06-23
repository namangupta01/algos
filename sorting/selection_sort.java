public class selectionSort {

    public static void doSelectionSort(int a[]){
        int size = a.length;
        for (int i = 0; i < size-1; i++) {
            int small = a[i];
            int smallIndex = i;
            for (int j = i+1; j < size; j++) {
                if(a[j] < small){
                    small = a[j];
                    smallIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[smallIndex];
            a[smallIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int a[] = {10, 23, 0, 50, 12, 99, 56, 2, 1, 11};
        System.out.println("Unsorted Array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        doSelectionSort(a);
        System.out.println("Sorted array using selection sort is:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
