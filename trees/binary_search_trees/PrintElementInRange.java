import java.util.Scanner;

public class PrintElementInRange {
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

    public static void printNodeFromK1ToK2(BinaryTreeNode<Integer> root,int k1,int k2){
        if (root == null){
            return;
        }
        if (k1<=root.data){
            printNodeFromK1ToK2(root.left, k1, Math.min(root.data,k2));

        }
        if (k1 <= root.data && k2>=root.data){
            System.out.print(root.data + " ");
        }
        if (k2>=root.data){
            printNodeFromK1ToK2(root.right, Math.max(root.data,k1), k2);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        System.out.println("Enter the left side of range:");
        Scanner s = new Scanner(System.in);
        int ldata = s.nextInt();
        System.out.println("Enter the right side of range:");
        int rdata = s.nextInt();
        printNodeFromK1ToK2(root,ldata, rdata);
    }
}
