import java.util.Arrays;

public class TripletSum1 {

    public static void findTriplets(int arr[], int num){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == num){
                        int triplet[] = {arr[i], arr[j], arr[k]};
                        Arrays.sort(triplet);
                        System.out.println(triplet[0] + " " + triplet[1] + " " + triplet[2]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 6, 8, 5, 4, 3, 0, 2, 2, 1};
        int num = 5;
        findTriplets(arr, num);
    }
}
