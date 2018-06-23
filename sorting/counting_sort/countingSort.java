// This sort is applied when number lie in a given range

public class countingSort {
    
    public static void doCountingSort(int a[], int lowerRange, int upperRange){
        int b[] = new int[upperRange+1];
        for (int i = 0; i < a.length; i++) {
            b[a[i]]++;
        }
        int count = 0;
        for (int j = lowerRange; j <= upperRange; j++) {
            if(b[j]!=0){
                for (int k = 1; k <= b[j]; k++) {
                    a[count] = j;
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int lowerRange = 0;
        int upperRange = 100;
        int a[] = {10, 23, 0, 50, 12, 99, 56, 2, 1, 11, 0, 100, 90, 4, 87, 3};
        System.out.println("Unsorted Array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        doCountingSort(a, lowerRange, upperRange);
        System.out.println("Sorted Array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
