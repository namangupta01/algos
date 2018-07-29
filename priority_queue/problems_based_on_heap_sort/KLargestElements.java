import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KLargestElements {
    public static ArrayList<Integer> kLargest(int input[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2){
                    return 1;
                }
                else if (o1==o2){
                    return 0;
                }
                else
                {
                    return -1;
                }
            }
        });
        for (int i = 0; i < input.length; i++) {
            pq.add(input[i]);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            arr.add(pq.remove());
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] input = {10, 9, 2, 11, -1, 15, 25, 1, 2, -100, 0, 54, 3, 23, 21, 45, 65, 23, 12, 21, -11};
        ArrayList<Integer> arr = kLargest(input, 5);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
