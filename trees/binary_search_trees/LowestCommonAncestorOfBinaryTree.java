import java.util.Scanner;

public class LowestCommonAncestorOfBinaryTree {

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

    public static BinaryTreeNode<Integer> lcaBinaryTreeHelper(BinaryTreeNode <Integer> root , int a, int b){
        if (root == null){
            return null;
        }
        if (root.data == a || root.data == b){
            return root;
        }
        BinaryTreeNode<Integer> node1 = lcaBinaryTreeHelper(root.left, a, b);
        BinaryTreeNode<Integer> node2 = lcaBinaryTreeHelper(root.right, a, b);
        if (node1 == null && node2 == null){
            return null;
        }
        if (node1 == null || node2 == null){
            if (node1 != null){
                return node1;
            }
            else {
                return node2;
            }
        }
        return root;
    }

    public static int lcaBinaryTree(BinaryTreeNode<Integer> root, int a, int b){
        BinaryTreeNode<Integer> node = lcaBinaryTreeHelper(root, a, b);
        if (node == null){
            return -1;
        }
        else{
            return node.data;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        System.out.println("Enter the first data");
        int data1 = s.nextInt();
        System.out.println("Enter the second data");
        int data2 = s.nextInt();
        System.out.println("Lowest Common Ancestor is :");
        System.out.println(lcaBinaryTree(root, data1, data2));
    }
}

// Input/Output
//        5
//        Enter left child of 5
//        10
//        Enter right child of 5
//        6
//        Enter left child of 10
//        2
//        Enter right child of 10
//        3
//        Enter left child of 6
//        -1
//        Enter right child of 6
//        -1
//        Enter left child of 2
//        -1
//        Enter right child of 2
//        -1
//        Enter left child of 3
//        -1
//        Enter right child of 3
//        9
//        Enter left child of 9
//        -1
//        Enter right child of 9
//        -1
//        5
//        10 6
//        2 3
//        9
//        Enter the first data
//        12
//        Enter the second data
//        78
//        Lowest Common Ancestor is :
//        -1
//
// -1 means both node are not present
