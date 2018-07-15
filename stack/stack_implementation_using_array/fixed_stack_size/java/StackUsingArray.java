public class StackUsingArray {
    private int stack[];
    int top = -1;

    StackUsingArray(){
        stack = new int[10];
    }

    StackUsingArray(int size){
        stack = new int[size];
    }

    public int size(){
        return top + 1;
    }

    public boolean isEmpty(){
        return (top==-1);
    }

    public void push(int data) throws StackOverflowException{
        if (top == stack.length-1){
            throw new StackOverflowException();
        }
        else{
            stack[top+1] = data;
            top = top + 1;
        }
    }
    public int top() throws StackUnderflowException{
        if (top == -1){
            throw new StackUnderflowException();
        }
        else{
            return stack[top];
        }
    }
    public int pop() throws StackUnderflowException{
        if (top == -1){
            throw new StackUnderflowException();
        }
        else{
            top = top - 1;
            return stack[top+1];
        }
    }

}
