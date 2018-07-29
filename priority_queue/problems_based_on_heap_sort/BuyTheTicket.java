import java.util.Comparator;
import java.util.PriorityQueue;

public class BuyTheTicket {

    public static int buyTicket(int input[], int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                if (p1.first < p2.first){
                    return 1;
                }
                else if(p1.first == p2.first){
                    return 0;
                }
                else{
                    return -1;
                }
            }
        });
        for (int i = 0; i < input.length; i++) {
            Pair<Integer, Integer> p = new Pair<>();
            p.first = input[i];
            p.second = i;
            pq.add(p);
        }
        int count = 0;
        while(!pq.isEmpty()){
            Pair<Integer, Integer> p = pq.remove();
            count++;
            if (p.second == k){
                return count;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {3, 9, 4};
        System.out.println(buyTicket(arr, 2));
    }
}
