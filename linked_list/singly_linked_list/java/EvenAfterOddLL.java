import java.util.Scanner;

public class EvenAfterOddLL {
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

    public static Node<Integer> evenAfterODD(Node<Integer> head){
        Node<Integer> odd = null;
        Node<Integer> odd_start = null;
        Node<Integer> even = null;
        Node<Integer> even_start = null;

        Node<Integer> current = head;
        while (current != null){
            if (current.data%2 != 0){
                if (odd == null){
                    odd = current;
                    odd_start = current;
                }
                else{
                    odd.next = current;
                    odd = current;
                }
            }
            else{
                if (even == null){
                    even = current;
                    even_start = current;
                }
                else{
                    even.next = current;
                    even = current;
                }
            }
            Node<Integer>temp = current;
            current = current.next;
            temp.next = null;
        }

        if (odd!=null){
            odd.next = even_start;
        }
        else{
            odd_start = even_start;
        }
        return odd_start;
    }



    public static void main(String[] args) {
        Node<Integer> head = input();
        printLinkedList(evenAfterODD(head));
    }
}
