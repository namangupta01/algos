import java.util.Scanner;

public class CheckIfBinaryTreeIsBST {
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

    public static Triplet<Boolean, Integer, Integer> isBSTT(BinaryTreeNode<Integer> root) {
        Triplet<Boolean, Integer, Integer> p = new Triplet<>();
        if (root == null){
            p.first = true;
            p.second = -1;
            p.third = -1;
            return p;
        }
        Triplet<Boolean, Integer, Integer> lp = isBSTT(root.left);
        Triplet<Boolean, Integer, Integer> rp = isBSTT(root.right);
        if (lp.first == true && rp.first == true){
            if (lp.third == -1){
                lp.third = root.data;
                lp.second = root.data;
            }
            if (rp.second == -1){
                rp.second = root.data;
                rp.third = root.data;
            }
            if (lp.third <= root.data && rp.second >= root.data  ){
                p.second = lp.second;
                p.third = rp.third;
                p.first = true;
                return p;
            }
            else{
                p.first = false;
                return p;
            }
        }
        else{
            p.first = false;
            return p;
        }
    }

    public static boolean isBST(BinaryTreeNode<Integer> root) {
        return isBSTT(root).first;

    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        System.out.println(isBST(root));
    }
}
