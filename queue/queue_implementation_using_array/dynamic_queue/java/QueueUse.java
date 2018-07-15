public class QueueUse {
    public static void main(String[] args) throws QueueUnderFlowError, QueueOverflowError{
        QueueUsingArrayDynamic q = new QueueUsingArrayDynamic();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        while (!q.isEmpty()){
            System.out.println(q.dequeue());
        }

    }
}
