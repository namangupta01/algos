import java.util.PriorityQueue;

public class KSortedArray {

    public static void sortKSortedArray(int input[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(input[i]);
        }
        int i = 0;
        for ( i = 0; i < input.length-k; i++) {
            input[i] = pq.remove();
            pq.add(input[i + k]);
        }
        while (!pq.isEmpty()){
            input[i] = pq.remove();
            i++;
        }
    }

    public static void main(String[] args) {
        int input[] = {2,4,1,9,5,8,10, 12, 11};
        sortKSortedArray(input, 3);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }
}

// Insertion complexity is O(nlog(k))
// Deletion complexity is O(nlog(k))
// Overall complexity is O(nlog(k))

