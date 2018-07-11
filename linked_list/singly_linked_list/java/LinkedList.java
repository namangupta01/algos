import java.util.Scanner;

public class LinkedList {

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

    public static void printLinkedList(Node<Integer> head){
        while (head!=null){
            System.out.print(head.data + " ");
            head = head.next;

        }
        System.out.println();
    }

    public static int length(Node<Integer> head){
        int count = 0;
        while(head!=null){
            head = head.next;
            count++;
        }
        return count;
    }

    public static Node<Integer> delete(Node<Integer> head, int index){
        int i = 0;
        Node<Integer> temp = head;
        while(temp!=null){
            if(temp.next != null && i+1 == index){
                temp.next = temp.next.next;
                return head;
            }
            i++;
            temp = temp.next;
        }
        return head;
    }

    public static void print(Node<Integer> head, int index){
        int i = 0;
        Node<Integer> temp = head;
        while (temp!=null){
            if (i==index){
                System.out.println(temp.data);
                return;
            }
            i++;
            temp = temp.next;
        }
        System.out.println("Length of list is shorter than index");

    }

    public static Node<Integer> replaceData(Node<Integer> head, int index, int num){
        int i = 0;
        Node<Integer> temp = head;
        while (temp!=null){
            if(i==index){
                temp.data = num;
                return head;
            }
            i++;
            temp = temp.next;
        }
        return head;
    }

    public static Node<Integer> addNode(Node<Integer> head, int index, int num){
        int i = 0;
        Node<Integer> temp = head;
        Node<Integer> newnode = new Node<>();
        newnode.data = num;
        while(temp!=null){
            if (i+1 == index){
                newnode.next = temp.next;
                temp.next = newnode;
                return head;
            }
            temp = temp.next;
            i++;
        }
        return head;
    }



    public static void main(String[] args) {
        Node<Integer> head = input();
        printLinkedList(head);
        System.out.println("Linked list length is " + length(head));
        System.out.println();
        System.out.println("Deletion in linked list");
        delete(head, 2);
        printLinkedList(head);
        System.out.println();
        System.out.println("Printing particular node in Linked List");
        print(head,1);
        System.out.println();
        System.out.println("Replace Data");
        head = replaceData(head, 1, 100);
        printLinkedList(head);
        System.out.println();
        System.out.println("Adding new node");
        head = addNode(head, 2, 200);
        printLinkedList(head);
    }
}
