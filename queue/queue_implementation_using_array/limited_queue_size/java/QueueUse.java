public class QueueUse {
    public static void main(String[] args) throws QueueUnderFlowError, QueueOverflowError{
        QueueUsingArray q = new QueueUsingArray();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        System.out.println(q.getSize());
        while (!q.isEmpty()){
            System.out.println(q.dequeue());
        }

    }
}
