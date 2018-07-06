public class ArraySorted1 {

    public static boolean isSorted(int []input){
        if (input.length == 1){
            return true;
        }
        int smallInput[] = new int[input.length-1];

        for (int i = 1; i < input.length; i++) {
            smallInput[i-1] = input[i];
        }

        if (isSorted(smallInput)){
            if (input[0] <= smallInput[0]){
                return true;
            }
            else {
                return false;
            }
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {
        int[] input  = { -4, -1, 0, 6, 8, 9};
        System.out.println(isSorted(input));
    }
}
