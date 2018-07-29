import java.util.PriorityQueue;
import java.util.ArrayList;

public class MergeKSortedArrays {
    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).size(); j++) {
                pq.add(input.get(i).get(j));
            }
        }
        ArrayList<Integer> output = new ArrayList<>();
        while (!pq.isEmpty()){
            output.add(pq.remove());
        }
        return output;
    }

    public static void main(String[] args) {
        // Pass arraylist of arraylist to sort all the arraylist to return a arraylist
    }
}
