import java.util.Scanner;

public class NodePresent {

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

    public static boolean isNodePresent(BinaryTreeNode<Integer> root,int x){
        if (root == null){
            return false;
        }
        if (root.data == x){
            return true;
        }
        if (isNodePresent(root.left, x)){
            return true;
        }
        if (isNodePresent(root.right, x)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        System.out.println("Enter the node data which is to be find : ");
        int data = s.nextInt();
        printLevelWise(root);
        System.out.println();
        System.out.println("Node Present " + isNodePresent(root, data));
    }
}


//        1
//        Enter left child of 1
//        2
//        Enter right child of 1
//        3
//        Enter left child of 2
//        4
//        Enter right child of 2
//        5
//        Enter left child of 3
//        6
//        Enter right child of 3
//        7
//        Enter left child of 4
//        -1
//        Enter right child of 4
//        -1
//        Enter left child of 5
//        -1
//        Enter right child of 5
//        -1
//        Enter left child of 6
//        -1
//        Enter right child of 6
//        -1
//        Enter left child of 7
//        -1
//        Enter right child of 7
//        -1
//        Enter the node data which is to be find :
//        10
//        1
//        2 3
//        4 5 6 7
//
//        Node present : false