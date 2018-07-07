public class CheckSorted3 {

    public static boolean checkSort(int input[], int startIndex){
        if (startIndex == input.length -1 ){
            return true;
        }
        else{
            if (input[startIndex] > input[startIndex+1]){
                return false;
            }
            else{
                return checkSort(input, startIndex+1);
            }
        }
    }

    public static void main(String[] args) {
        int []input = { -4, -1, 0, 6, 8, 9};
        System.out.println(checkSort(input, 0));
    }
}
