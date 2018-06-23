// Sort a large set of floating point numbers which are in the range from 0.0 to 1.0

public class bucketSort {

    public static void doBucketSort(double a[]) {
        int size = a.length;
        int index[] = new int[10];
        double b[][] = new double[10][size];
        for (int i = 0; i < size; i++) {
            int number = (int) (a[i] * 10);
            int j;
            for (j = 0; j < index[number]; j++) {
                if (b[number][j] > a[i]) {
                    break;
                }
            }
            double pre = b[number][j];
            b[number][j] = a[i];
            for (int k = j + 1; k < index[number] + 1; k++) {
                double temp = b[number][k];
                b[number][k] = pre;
                pre = temp;

            }
            index[number]++;
        }
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if(index[i]!=0){
                for (int j = 0; j < index[i]; j++) {
                    a[count] = b[i][j];
                    count++;
                }
            }

        }
    }


    public static void main(String[] args) {

        double a[] = {0.1, 0.23, 0.0, 0.50, 0.12, 0.99, 0.56, 0.2, 0.1, 0.11};
        System.out.println("Unsorted Array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        doBucketSort(a);
        System.out.println("Sorted Array: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
