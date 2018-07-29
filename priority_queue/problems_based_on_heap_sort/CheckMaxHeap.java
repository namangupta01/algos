public class CheckMaxHeap {
    public static boolean checkMaxHeap(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (((2*i+1) < arr.length) && arr[i] < arr[2*i+1] ){
                return false;
            }
            if ((2*i+2) < arr.length && arr[i] < arr[2*i+2] ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] = {20, 94032, 91513, 83822, 86096, 77055, 65181, 59534, 63999, 84904, 35945, 21525, 44579, 45064, 36554, 51655, 9737, 548, 53228, 26519, 17196};
        System.out.println(checkMaxHeap(arr));
    }
}
