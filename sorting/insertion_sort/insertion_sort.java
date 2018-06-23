public class InsetionSort {

    public static void insertionSort(int a[]){
        int size = a.length;
        for (int i = 1; i < size; i++) {
            int j = i-1;
            while(j>=0){
                if(a[j]>a[j+1]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                    j--;
                }
                else{
                    break;
                }
            }
        }
    }

    public static void main(String args[]){
        int a[] = {10, 23, 0, 50, 12, 99, 56, 2, 1, 10};
        insertionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
