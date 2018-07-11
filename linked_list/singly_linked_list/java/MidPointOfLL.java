import java.util.Scanner;

public class MidPointOfLL {
    public static Node<Integer> input(){
        System.out.println("Give input to the Linked List");
        Node<Integer> head = null;
        Node<Integer> tail = null;
        Scanner scanner =  new Scanner(System.in);
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


    public static int findMid(Node<Integer> head){
        Node<Integer> fast = head;
        Node<Integer> slow = head;
        while(fast!=null && fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public static void main(String[] args) {
        Node<Integer> head = input();
        int mid = findMid(head);
        System.out.println("Mid point of linked list have value :");
        System.out.println(mid);
    }
}
