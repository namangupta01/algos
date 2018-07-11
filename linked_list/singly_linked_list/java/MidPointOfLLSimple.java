import java.util.Scanner;

public class MidPointOfLLSimple {
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


    public static int findMid(Node<Integer> head){
        //First of all find length
        int length = 0;
        Node<Integer>temp = head;
        while (temp!=null){
            length++;
            temp = temp.next;
        }
        int i = 0;
        temp = head;
        while(i<(length)/2){
            temp = temp.next;
            i++;
        }
        return temp.data;
    }

    public static void main(String[] args) {
        Node<Integer> head = input();
        int mid = findMid(head);
        System.out.println("Mid point of linked list have value :");
        System.out.println(mid);
    }
}
