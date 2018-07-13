import java.util.Scanner;

public class DeleteRecursively {
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

    public static void printLinkedList(Node<Integer> head){
        while (head!=null){
            System.out.print(head.data + " ");
            head = head.next;

        }
        System.out.println();
    }

    public static Node<Integer> delete(Node<Integer> head, int pos){
        if (head==null){
            return head;
        }
        if (pos == 0){
            return head.next;
        }
        head.next = delete(head.next, pos-1);
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = input();
        System.out.println("Enter the position");
        int pos = scanner.nextInt();
        head = delete(head, pos);
        printLinkedList(head);
    }
}
