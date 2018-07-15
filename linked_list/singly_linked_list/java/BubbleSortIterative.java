import java.util.Scanner;

public class BubbleSortIterative {
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

    public static Node<Integer> bubbleSort(Node<Integer> head){
        int count = 0;
        Node<Integer> temp = head;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        for (int i = 0; i < count-1 ; i++){
            Node<Integer> node = head;
            Node<Integer> pre = null;
            for (int j = 0; j < count-i-1; j++) {
                if (node.data > node.next.data){
                    if (node == head){
                        temp = head.next;
                        head.next = head.next.next;
                        temp.next = head;
                        head = temp;
                        pre = head;
                    }
                    else{
                        temp = node.next;
                        node.next = temp.next;
                        pre.next = temp;
                        temp.next = node;
                        pre = pre.next;
                    }
                }
                else{
                    node = node.next;
                    if (pre == null){
                        pre = head;
                    }
                    else{
                        pre = pre.next;
                    }

                }
            }
        }
        return head;
    }


    public static void main(String[] args) {
        Node<Integer> head = input();
        printLinkedList(bubbleSort(head));
    }
}
