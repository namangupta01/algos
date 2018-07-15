public class StackDoubleCapacityUsingArray {
    private int stack[];
    int top = -1;

    StackDoubleCapacityUsingArray(){
        stack = new int[10];
    }

    StackDoubleCapacityUsingArray(int size){
        stack = new int[size];
    }

    public int size(){
        return top + 1;
    }

    public boolean isEmpty(){
        return (top==-1);
    }

    private void doubleStack(){
        int newarray[] = new int[stack.length*2];
        for (int i = 0; i <= top ; i++) {
            newarray[i] = stack[i];
        }
        stack = newarray;
    }

    public void push(int data) throws StackOverflowException{
        if (top == stack.length-1){
            doubleStack();
        }
        stack[top+1] = data;
        top = top + 1;
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
