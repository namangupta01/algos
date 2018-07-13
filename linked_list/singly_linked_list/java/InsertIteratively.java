import java.util.Scanner;

public class InsertIntertively {

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

    public static Node<Integer> insert(Node<Integer> head, int pos, int num){
        int i = 0;
        if (i==pos){
            Node<Integer> newNode = new Node<>();
            newNode.data = num;
            newNode.next = head;
            return newNode;
        }
        Node<Integer> temp = head;
        while (i + 1 < pos && temp.next != null){
            temp = temp.next;
            i++;
        }
        if (temp.next!=null) {
            Node<Integer> newNode = new Node<>();
            newNode.data = num;
            newNode.next = temp.next;
            temp.next = newNode;
        }
        return head;
    }



    public static void main(String[] args) {
        Node<Integer> head = input();
        System.out.println("Insert position where to insert element in Linked List");
        int pos = scanner.nextInt();
        System.out.println("Enter the number");
        int num = scanner.nextInt();
        head = insert(head, pos, num);
        printLinkedList(head);
    }
}
