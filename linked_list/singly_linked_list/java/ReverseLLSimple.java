import java.util.Scanner;

public class ReverseLLSimple {
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

    public static Node<Integer> reverseLL(Node<Integer> head){
        if (head==null || head.next==null){
            return head;
        }

        Node<Integer> ansHead = reverseLL(head.next);
        Node<Integer> temp = ansHead;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = head;
        head.next = null;
        return ansHead;
    }

    public static void main(String[] args) {
        Node<Integer> head = input();
        head = reverseLL(head);
        printLinkedList(head);
    }
}

// Complexity of reversing linked list using this method is T(n) = T(n-1) + n-1 which leads to complexity of O(n^2)
