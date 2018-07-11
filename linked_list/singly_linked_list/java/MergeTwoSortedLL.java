import java.util.Scanner;

public class MergeTwoSortedLL {
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

    public static Node<Integer> mergeLL(Node<Integer>head1, Node<Integer>head2){
        Node<Integer> head = null;
        Node<Integer> temp = null;
        while (head1!=null && head2!=null){
            if (head1.data < head2.data){
                if (head==null){
                    head = head1;
                    head1 = head1.next;
                    temp = head;
                }
                else{
                    temp.next = head1;
                    temp = temp.next;
                    head1 = head1.next;
                }
            }
            else{
                if (head==null){
                    head = head2;
                    head2 = head2.next;
                    temp = head;
                }
                else{
                    temp.next = head2;
                    temp = temp.next;
                    head2 = head2.next;
                }
            }
        }
        if (head1!=null){
            temp.next = head1;
        }

        if (head2!=null){
            temp.next = head2;
        }
        return head;
    }


    public static void main(String[] args) {
        Node<Integer> head1 = input();
        Node<Integer> head2 = input();
        System.out.println("Asd");
        Node<Integer> head = mergeLL(head1, head2);
        printLinkedList(head);
    }
}
