public class BinarySearch {

    public static int binarySearch(int input[], int element, int start, int end) {
        if(start > end){
            return -1;
        }
        int mid = (start + end ) / 2;
        if (input[mid] == element){
            return mid;
        }
        int ans1 = binarySearch(input, element, start, mid-1);
        int ans2 = binarySearch(input, element, mid+1, end);
        if (ans1 == -1){
            return ans2;
        }
        return ans1;
    }

    public static int binarySearch(int input[], int element) {
        return binarySearch(input, element, 0, input.length-1);
    }

    public static void main(String[] args) {
        int [] input = {12, 9, -2, 340, -8, 0, 23};
        System.out.println(binarySearch(input,0));

    }
}
