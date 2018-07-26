import java.util.Scanner;

public class CreateaAndInsertDuplicateNode {

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

    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        if (root == null){
            return;
        }
        insertDuplicateNode(root.left);
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(root.data);
        if (root.left!=null){
            node.left = root.left;
            root.left = node;
        }
        else{
            root.left = node;
        }
        insertDuplicateNode(root.right);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        insertDuplicateNode(root);
        System.out.println();
        printLevelWise(root);
    }
}
//  Input/Output
//        8
//        Enter left child of 8
//        5
//        Enter right child of 8
//        10
//        Enter left child of 5
//        2
//        Enter right child of 5
//        6
//        Enter left child of 10
//        -1
//        Enter right child of 10
//        -1
//        Enter left child of 2
//        -1
//        Enter right child of 2
//        -1
//        Enter left child of 6
//        -1
//        Enter right child of 6
//        7
//        Enter left child of 7
//        -1
//        Enter right child of 7
//        -1
//        8
//        5 10
//        2 6
//        7
//
//        8
//        8 10
//        5 10
//        5 6
//        2 6 7
//        2 7
