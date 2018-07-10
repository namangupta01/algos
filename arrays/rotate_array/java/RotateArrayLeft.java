public class RotateArrayLeft {

    public static void rotate(int arr[], int rotateBy){
        int temp[] = new int[rotateBy];
        for (int i = 0; i < rotateBy; i++) {
            temp[i] = arr[i];
        }
        for (int i = rotateBy; i < arr.length; i++) {
            arr[i-rotateBy] = arr[i];
        }
        for (int i = arr.length-rotateBy; i < arr.length; i++) {
            arr[i] = temp[i-(arr.length-rotateBy)];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 6, 8, 5, 4, 3, 0, 2, 2, 1};
        int rotateBy = 3;
        rotate(arr, rotateBy);
    }
}
