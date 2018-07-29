public class InPlaceHeapSort {

    private static void insert(int input[], int index){
        int childIndex = index;
        int parentIndex = (index - 1)/2;
        while (childIndex!=0 && input[childIndex] < input[parentIndex]){
            int temp = input[parentIndex];
            input[parentIndex] = input[childIndex];
            input[childIndex] = temp;
            childIndex = parentIndex;
            parentIndex = (childIndex - 1)/2;
        }
        return;
    }

    private static void remove(int []input, int size){
        int temp = input[0];
        input[0] = input[size-1];
        input[size-1] = temp;
        int parentIndex = 0;
        int leftchildIndex = (parentIndex*2)+1;
        int rightchildIndex = (parentIndex*2)+2;
        while (leftchildIndex < size - 1){
            int minIndex = parentIndex;
            if (input[leftchildIndex] < input[parentIndex]){
                minIndex = leftchildIndex;
            }
            if (rightchildIndex < size - 1){
                if (input[rightchildIndex] < input[minIndex]){
                    minIndex = rightchildIndex;
                }
            }
            if (minIndex == parentIndex){
                return;
            }
            temp = input[parentIndex];
            input[parentIndex] = input[minIndex];
            input[minIndex] = temp;
            parentIndex = minIndex;
            leftchildIndex = (minIndex*2 + 1);
            rightchildIndex = (minIndex*2 + 2);
        }

    }

    public static void inplaceHeapSort(int input[]) {
        for (int i = 0; i < input.length; i++) {
            insert(input, i);
        }
        System.out.println("After insertion array is :");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < input.length; i++) {
            remove(input, input.length - i);
        }

        System.out.println("Sorted array is :");
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }

    }

    public static void main(String[] args) {
        int[] input = {10, 9, 2, 11, -1, 15, 25, 1, 2, -100, 0, 54, 3, 23, 21, 45, 65, 23, 12, 21, -11};
        inplaceHeapSort(input);
    }
}

// Space complexity is 0(1)
// Time complexity is 0(nlogn)
