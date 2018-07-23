import java.util.Scanner;

public class MirrorBinaryTree {

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

    public static void mirror(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        mirror(root);
        System.out.println("Mirror Tree is : ");
        printLevelWise(root);
    }
}
