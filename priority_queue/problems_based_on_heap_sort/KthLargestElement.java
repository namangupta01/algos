import java.util.PriorityQueue;

public class KthLargestElement {
    public static int kthLargest(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (pq.peek() < arr[i]){
                pq.remove();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int arr[] = {20, 94032, 91513, 83822, 86096, 77055, 65181, 59534, 63999, 84904, 35945, 21525, 44579, 45064, 36554, 51655, 9737, 548, 53228, 26519, 17196};
        System.out.println(kthLargest(arr, 5));
    }
}
