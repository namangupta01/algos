import java.util.Scanner;

public class LowestCommonAncestorOfBST {
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

    public static int lcaOfBST(BinaryTreeNode <Integer> root , int a, int b){
        if (root == null){
            return -1;
        }
        if (root.data < Math.min(a,b)){
            return lcaOfBST(root.right, a, b);
        }
        else if (root.data > Math.max(a, b)){
            return lcaOfBST(root.left, a, b);
        }
        if (root.data == Math.min(a,b)){
            if (isPresent(root.right, Math.max(a, b))){
                return Math.min(a,b);
            }
            else{
                return -1;
            }
        }
        else if (root.data == Math.max(a, b)){
            if (isPresent(root.left, Math.min(a, b))){
                return Math.max(a,b);
            }
            else{
                return -1;
            }
        }
        if (root.data < Math.max(a, b) && root.data > Math.min(a,b)){
            if (isPresent(root.left, Math.min(a,b )) && isPresent(root.right, Math.max(a,b ))){
                return root.data;
            }
            else return -1;
        }
        return -1;
    }

    public static boolean isPresent(BinaryTreeNode<Integer> root, int data){
        if (root == null){
            return false;
        }
        if (root.data == data){
            return true;
        }
        else if (root.data>data){
            return isPresent(root.left, data);
        }
        else{
            return isPresent(root.right, data);
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
        System.out.println(lcaOfBST(root, data1, data2));
    }
}

// Input/Output
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
//        Enter the first data
//        12
//        Enter the second data
//        78
//        Lowest Common Ancestor is :
//        -1

