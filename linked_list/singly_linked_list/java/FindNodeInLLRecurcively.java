import java.util.Scanner;

public class FindNodeInLLRecurcively {
    static Scanner scanner =  new Scanner(System.in);

    public static Node<Integer> input(){
        Node<Integer> head = null;
        Node<Integer> tail = null;
        int data = scanner.nextInt();
        while (data != -1){
            Node<Integer> newNode = new Node();
            newNode.data = data;
            if (head == null){
                head = newNode;
                tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }
            data = scanner.nextInt();
        }
        return head;
    }

    public static int findNode(Node<Integer> head, int num){
        if(head==null){
            return -1;
        }
        if(head.data==num){
            return 0;
        }
        int count = findNode(head.next, num);
        if (count == -1){
            return -1;
        }
        else{
            return count+1;
        }
    }


    public static void main(String[] args) {
        Node<Integer> head = input();
        System.out.println("Enter the node data which is be found");
        int num = scanner.nextInt();
        System.out.println(findNode(head, num));
    }
}
