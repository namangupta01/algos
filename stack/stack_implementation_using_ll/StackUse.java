public class StackUse {
    public static void main(String[] args) throws StackOverflowException, StackUnderflowException{
        StackUsingLL<Integer> s = new StackUsingLL();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        System.out.println("Top is : " + s.getTop().data);
        System.out.println("Size is : " + s.getSize());
        while (!s.isEmpty()){
            System.out.println(s.pop().data);
        }
    }
}
