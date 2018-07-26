import java.util.ArrayList;
import java.util.Scanner;

public class PathSumRootToLeaf {

    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the root node");
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

    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int sum) {
        if (root == null){
            return;
        }
        ArrayList<Integer> a = new ArrayList<>();
        rootToLeafPathsSumToKHelper(root.left, sum, a);
        rootToLeafPathsSumToKHelper(root.right, sum,a);
        a.add(root.data);
        rootToLeafPathsSumToKHelper(root.left, sum-root.data, a);
        rootToLeafPathsSumToKHelper(root.right, sum-root.data, a);
    }

    public static void rootToLeafPathsSumToKHelper(BinaryTreeNode<Integer> root, int sum, ArrayList<Integer> a) {
        if (root == null){
            return;
        }
        if (root.data == sum){
            for (int i = 0; i < a.size(); i++) {
                System.out.print(a.get(i) + " ");
            }
            System.out.print(root.data);
            System.out.println();
        }
        else{
            a.add(root.data);
            rootToLeafPathsSumToKHelper(root.left, sum-root.data, a);
            rootToLeafPathsSumToKHelper(root.right, sum-root.data, a);
            a.remove(root.data);
        }
        rootToLeafPathsSumToKHelper(root.left, sum, a);
        rootToLeafPathsSumToKHelper(root.right, sum, a);
    }



    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        System.out.println("Enter the sum whose pair is to found");
        int sum = s.nextInt();
        rootToLeafPathsSumToK(root, sum);
    }
}


// Input/Output
//        Enter the root node
//        5
//        Enter left child of 5
//        6
//        Enter right child of 5
//        7
//        Enter left child of 6
//        2
//        Enter right child of 6
//        3
//        Enter left child of 7
//        -1
//        Enter right child of 7
//        1
//        Enter left child of 2
//        -1
//        Enter right child of 2
//        -1
//        Enter left child of 3
//        -1
//        Enter right child of 3
//        9
//        Enter left child of 1
//        -1
//        Enter right child of 1
//        -1
//        Enter left child of 9
//        -1
//        Enter right child of 9
//        -1
//        5
//        6 7
//        2 3 1
//        9
//        Enter the sum whose pair is to found
//        13
//        5 6 2
//        5 7 1
