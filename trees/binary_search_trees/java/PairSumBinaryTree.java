import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PairSumBinaryTree {
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


    public static void nodesSumToS(BinaryTreeNode<Integer> root, int sum) {
        if (root == null){
            return;
        }
        ArrayList<Integer> a = new ArrayList<>();
        a = treeToArrayList(root, a);
        Collections.sort(a);
        int i = 0;
        int j = a.size()-1;
        while (i < j){
            if (a.get(i) + a.get(j) == sum){
                System.out.println(Math.min(a.get(i), a.get(j)) + " " + Math.max(a.get(i), a.get(j)));
                i++;
                j--;
            }
            else if (a.get(i) + a.get(j) > sum){
                j--;
            }
            else{
                i++;
            }
        }
    }

    public static ArrayList<Integer> treeToArrayList(BinaryTreeNode<Integer> root, ArrayList<Integer> a){
        if (root == null){
            return a;
        }
        a.add(root.data);
        treeToArrayList(root.left, a);
        treeToArrayList(root.right, a);
        return a;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);
        System.out.println("Enter the sum whose pair is to found");
        int sum = s.nextInt();
        nodesSumToS(root, sum);
    }
}
//  Input/ Output
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
//        Enter the sum whose pair is to found
//        15
//        5 10
//        6 9


