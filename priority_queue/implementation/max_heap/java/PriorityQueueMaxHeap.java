import java.util.ArrayList;
import java.util.Scanner;

public class PriorityQueueMaxHeap {
    private ArrayList<Integer> heap;

    PriorityQueueMaxHeap(){
        heap =  new ArrayList<>();
    }

    public boolean isEmpty(){
        return heap.size() == 0;
    }

    public int getMax() throws PriorityQueueException{
        if (heap.size() == 0){
            throw new PriorityQueueException();
        }
        return heap.get(0);
    }

    public void insert(int element){
        heap.add(heap.size(), element);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1)/2;
        while (childIndex!=0 && heap.get(parentIndex) < heap.get(childIndex)){
            int temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(childIndex));
            heap.set(childIndex, temp);
            childIndex = parentIndex;
            parentIndex = (childIndex - 1)/2;
        }
    }

    public int removeMax() throws PriorityQueueException{
        if (heap.size() == 0){
            throw new PriorityQueueException();
        }
        int removedElement = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int parentIndex = 0;
        int leftChildIndex = (parentIndex*2) + 1;
        int rightChildIndex = (parentIndex*2) + 2;
        while (leftChildIndex < heap.size() && rightChildIndex < heap.size()){
            if (heap.get(leftChildIndex) > heap.get(rightChildIndex) && heap.get(leftChildIndex) > heap.get(parentIndex)){
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(leftChildIndex));
                heap.set(leftChildIndex, temp);
                parentIndex = leftChildIndex;
                leftChildIndex = (parentIndex*2)+1;
                rightChildIndex = (parentIndex*2)+2;
            }
            else if(heap.get(rightChildIndex) > heap.get(leftChildIndex) && heap.get(rightChildIndex) > heap.get(parentIndex)){
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(rightChildIndex));
                heap.set(rightChildIndex, temp);
                parentIndex = rightChildIndex;
                leftChildIndex = (parentIndex*2)+1;
                rightChildIndex = (parentIndex*2)+2;
            }
            else{
                return removedElement;
            }
        }
        if (leftChildIndex < heap.size()){
            if (heap.get(parentIndex) < heap.get(leftChildIndex)){
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(leftChildIndex));
                heap.set(leftChildIndex, temp);
            }
        }
        else if (rightChildIndex < heap.size()){
            if (heap.get(parentIndex) < heap.get(rightChildIndex)){
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(leftChildIndex));
                heap.set(leftChildIndex, temp);
            }
        }
        return removedElement;
    }

    int size(){
        return heap.size();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PriorityQueueMaxHeap pq = new PriorityQueueMaxHeap();
        int choice = s.nextInt();
        while(choice != -1) {
            switch(choice) {
                case 1 : // insert
                    int element = s.nextInt();
                    pq.insert(element);
                    break;
                case 2 : // getMin
                    try {
                        System.out.println(pq.getMax());
                    } catch (PriorityQueueException e) {
                        return;
                    }
                    break;
                case 3 : // removeMin
                    try {
                        System.out.println(pq.removeMax());
                    } catch (PriorityQueueException e) {
                        return;
                    }
                    break;
                case 4 : // size
                    System.out.println(pq.size());
                    break;
                case 5 : // isEmpty
                    System.out.println(pq.isEmpty());
                    break;
                default :
                    return;
            }
            choice = s.nextInt();
        }
    }
}
