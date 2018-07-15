public class QueueUsingArrayDynamic {
    private int data[];
    private int front;
    private int rear;
    private int size;

    QueueUsingArrayDynamic(){
        data = new int[3];
        front = -1;
        rear = -1;
        size = 0;
    }

    private void doubleQueue(){
        int newArray[] = new int[2*data.length];
        int k = 0;
        while (k<data.length){
            newArray[k] = data[front];
            front++;
            if (front == data.length){
                front = 0;
            }
            k++;
        }
        data = newArray;
    }

    public void enqueue(int data) throws QueueOverflowError{
        if (size == this.data.length){
            doubleQueue();
            front = 0;
            this.data[size] = data;
            rear = size;
            size++;
            return ;
        }
        if (rear == -1){
            rear++;
            front++;
            this.data[rear] = data;
        }
        else if (rear == this.data.length-1){
            rear = 0;
            this.data[rear] = data;
        }
        else{
            rear = rear + 1;
            this.data[rear] = data;
        }
        size++;
    }

    public int dequeue() throws QueueUnderFlowError{
        if (size == 0){
            throw new QueueUnderFlowError();
        }
        else{
            if (front == this.data.length-1){
                size --;
                front = 0;
                if (size == 0){
                    front = -1;
                    rear = -1;
                }
                return this.data[this.data.length-1];
            }
            else{
                size--;
                front++;
                int temp = data[front-1];
                if (size == 0){
                    front = -1;
                    rear = -1;
                }
                return temp;
            }
        }
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public int front() throws QueueUnderFlowError{
        if (front == -1){
            throw new QueueUnderFlowError();
        }
        return data[front];
    }

    public int getSize(){
        return size;
    }

}
