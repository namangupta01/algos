import java.util.ArrayList;
import java.util.Scanner;
public class LevelWiseLinkedList {
    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        if (data == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        QueueUsingLinkedList<BinaryTreeNode<Integer>> q = new QueueUsingLinkedList<>();
        q.enqueue(root);
        while (!q.isEmpty()){
            try {
                BinaryTreeNode<Integer> node = q.dequeue();
                System.out.println("Enter left child of " + node.data);
                data = s.nextInt();
                if (data != -1){
                    BinaryTreeNode<Integer> left = new BinaryTreeNode<>(data);
                    node.left = left;
                    q.enqueue(left);
                }
                System.out.println("Enter right child of " + node.data);
                data = s.nextInt();
                if (data != -1){
                    BinaryTreeNode<Integer> right = new BinaryTreeNode<>(data);
                    node.right = right;
                    q.enqueue(right);
                }

            }
            catch (QueueUnderFlowError e){
                // Will never reach here
            }
        }
        return root;
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null){
            return;
        }
        QueueUsingLinkedList<BinaryTreeNode<Integer>> q = new QueueUsingLinkedList<>();
        q.enqueue(root);
        while (!q.isEmpty()){
            QueueUsingLinkedList<BinaryTreeNode<Integer>> q1 = new QueueUsingLinkedList();
            while (!q.isEmpty()){
                try {
                    BinaryTreeNode<Integer> node = q.dequeue();
                    System.out.print(node.data + " ");
                    if (node.left!=null){
                        q1.enqueue(node.left);
                    }
                    if (node.right!=null){
                        q1.enqueue(node.right);
                    }
                }
                catch (QueueUnderFlowError e){
                    // Never reach here
                }
            }
            System.out.println();
            q = q1;
        }
    }

    public static ArrayList<Node<BinaryTreeNode<Integer>>> LLForEachLevel(BinaryTreeNode<Integer> root) {

        ArrayList<Node<BinaryTreeNode<Integer>>> a= new ArrayList<>();
        if (root == null){
            return a;
        }
        QueueUsingLinkedList<BinaryTreeNode<Integer>> q = new QueueUsingLinkedList<>();
        q.enqueue(root);
        while (!q.isEmpty()){
            QueueUsingLinkedList<BinaryTreeNode<Integer>> q1 = new QueueUsingLinkedList();
            Node<BinaryTreeNode<Integer>> head = null;
            Node<BinaryTreeNode<Integer>> cur = null;
            while (!q.isEmpty()){
                try {
                    BinaryTreeNode<Integer> node = q.dequeue();
                    if (cur == null){
                        head = new Node<>(node);
                        cur = head;
                    }
                    else{
                        cur.next = new Node<>(node);
                        cur = cur.next;
                    }
                    if (node.left!=null){
                        q1.enqueue(node.left);
                    }
                    if (node.right!=null){
                        q1.enqueue(node.right);
                    }
                }
                catch (QueueUnderFlowError e){
                    // Never reach here
                }
            }
            a.add(head);
            q = q1;

        }
        return a;

    }

    public static void printLL(ArrayList<Node<BinaryTreeNode<Integer>>> a){
        for (int i = 0; i < a.size(); i++) {
            Node<BinaryTreeNode<Integer>> node = a.get(i);
            while (node != null){
                System.out.print(node.data.data + " ");
                node = node.next;
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        System.out.println();
        System.out.println("Printing Using Linked List");
        printLL(LLForEachLevel(root));
    }
}
