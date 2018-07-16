public class QueueUsingLinkedList<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public int getSize(){
        return size;
    }

    public void enqueue(T data){
        if (rear == null){
            Node<T> node = new Node<>();
            node.data = data;
            node.next = null;
            rear = node;
            front = node;
            size++;
        }
        else{
            Node<T> node = new Node<>();
            node.data = data;
            node.next = null;
            rear.next = node;
            rear = node;
            size++;
        }
    }

    public T dequeue() throws QueueUnderFlowError{
        if (front==null){
            throw new QueueUnderFlowError();
        }
        else{
            Node<T> temp;
            if (front == rear){
                temp = front;
                front = null;
                rear = null;
                return temp.data;
            }
            else{
                temp = front;
                front = front.next;
                size--;
            }
            return temp.data;
        }
    }

    public boolean isEmpty(){
        return (front==null);
    }

    public int size(){
        return size;
    }

    public T front() throws QueueUnderFlowError{
        if (front==null){
            throw new QueueUnderFlowError();
        }
        return front.data;
    }

}
