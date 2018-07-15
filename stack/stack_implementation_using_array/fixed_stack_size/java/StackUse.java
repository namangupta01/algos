public class StackUse {
    public static void main(String[] args) throws StackOverflowException, StackUnderflowException{
        StackUsingArray s = new StackUsingArray();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        System.out.println(s.size());
        while (!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
}
