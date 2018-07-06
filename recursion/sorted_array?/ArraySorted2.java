public class ArraySorted2 {

    public static boolean isSorted(int []input){
        if (input.length == 1){
            return true;
        }

        if (input[0] > input[1]){
            return false;
        }
        int smallInput[] = new int[input.length-1];

        for (int i = 1; i < input.length; i++) {
            smallInput[i-1] = input[i];
        }

        return isSorted(smallInput);
    }

    public static void main(String[] args) {
        int[] input  = { -4, -1, 0, 6, 8, 9};
        System.out.println(isSorted(input));
    }
}
