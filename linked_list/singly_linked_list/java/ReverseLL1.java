import java.util.Scanner;

public class ReverseLL1 {
    public static Node<Integer> input(){
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

    public static DoubleNode reverseLL(Node<Integer> head){
        if (head==null || head.next==null){
            DoubleNode d = new DoubleNode();
            d.head = head;
            d.tail = head;
            return d;
        }
        DoubleNode d = reverseLL(head.next);
        d.tail.next = head;
        d.tail = head;
        head.next = null;
        return d;
    }

    public static void main(String[] args) {
        Node<Integer> head = input();
        DoubleNode d = reverseLL(head);
        printLinkedList(d.head);
    }
}

class DoubleNode {
    Node<Integer> head;
    Node<Integer> tail;
}

// Complexity of this algorithm is
// T(n) = T(n-1)
// O(n)