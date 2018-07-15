public class StackUsingLL<T> {
    private Node<T> top;
    private int size;

    public boolean isEmpty(){
        return (top == null);
    }

    public int getSize(){
        return size;
    }

    public void push(T data){
        Node<T> node = new Node<>();
        node.data = data;
        node.next = top;
        top = node;
        size++;
    }

    public Node<T> pop() throws StackUnderflowException{
        if (size == 0){
            throw new StackUnderflowException();
        }
        Node<T> temp = top;
        top = top.next;
        size--;
        return temp;
    }

    public Node<T> getTop() throws StackUnderflowException{
        if (top == null) {
            throw new StackUnderflowException();
        }
        return top;
    }
}
