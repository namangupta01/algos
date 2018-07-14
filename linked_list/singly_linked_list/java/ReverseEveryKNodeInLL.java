import java.util.Scanner;

public class ReverseEveryKNodeInLL {
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

    public static Doublenode reverse(Node<Integer> head, int k){
        if (k == 1 || head.next == null){
            Doublenode d = new Doublenode();
            d.head = head;
            d.tail = head;
            d.next = head.next;
            return d;
        }
        Doublenode d = reverse(head.next, k - 1 );
        d.tail.next = head;
        d.tail = head;
        head.next = null;
        return d;
    }

    public static Node<Integer> KReverse(Node<Integer> head, int k){
        Node<Integer> temp = head;
        Doublenode d = reverse(head, k);
        temp = d.next;
        head = d.head;
        while(temp!=null && temp.next != null){
            Doublenode d1 = reverse(temp, k);
            d.tail.next = d1.head;
            temp = d1.next;
            d = d1;
        }
        if (temp!=null){
            d.tail.next=temp;
        }
        return head;
    }


    public static void main(String[] args) {
        Node<Integer> head = input();
        printLinkedList(KReverse(head, 4));
    }
}


class Doublenode{
    Node<Integer> head;
    Node<Integer> tail;
    Node<Integer> next;
}
