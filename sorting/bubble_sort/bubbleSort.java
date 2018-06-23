public class bubbleSort {

    public static void doBubbleSort(int a[]){
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if(a[j+1]<a[j]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {10, 23, 0, 50, 12, 99, 56, 2, 1, 11};
        System.out.println("Unsorted Array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        doBubbleSort(a);
        System.out.println("Sorted array using bubble sort is:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
