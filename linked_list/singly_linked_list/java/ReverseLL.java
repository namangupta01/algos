import java.util.Scanner;

public class ReverseLL {

    public static Node<Integer> input(){
        System.out.println("Enter elements of linked list in sorted order");
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

    public static void printLinkedList(Node<Integer> head){
        while (head!=null){
            System.out.print(head.data + " ");
            head = head.next;

        }
        System.out.println();
    }

    public static Node<Integer> reverseLL(Node<Integer> head, Node<Integer> preNode){
        if (head==null){
            return preNode;
        }
        else{
            Node<Integer> temp = head;
            head =  reverseLL(head.next, head);
            temp.next = preNode;
            return head;
        }
    }

    public static void main(String[] args) {
        Node<Integer> head = input();
        head = reverseLL(head, null);
        printLinkedList(head);
    }
}
