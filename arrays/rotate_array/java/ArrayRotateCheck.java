public class ArrayRotateCheck {

    public static int arrayRotateCheck(int []arr){
        int pre = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < pre){
                return arr.length - i;
            }
            else{
                pre = arr[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {5, 6, 8, 9, -8, 0, 2, 4};
        System.out.println(arrayRotateCheck(arr));
    }
}
