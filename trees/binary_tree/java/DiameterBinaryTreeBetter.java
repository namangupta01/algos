import java.util.Scanner;

public class DiameterBinaryTreeBetter {
    public static BinaryTreeNode<Integer> input(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the node");
        int data = s.nextInt();
        if (data == -1){
            return null;
        }
        QueueUsingLinkedList<BinaryTreeNode<Integer>> q = new QueueUsingLinkedList<>();
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        q.enqueue(root);
        System.out.println();
        while (!q.isEmpty()){
            try {
                BinaryTreeNode<Integer>node = q.dequeue();
                System.out.println("Enter the left child of " + node.data);
                data = s.nextInt();
                if (data != -1){
                    BinaryTreeNode<Integer> left = new BinaryTreeNode<>(data);
                    node.left = left;
                    q.enqueue(left);
                }
                System.out.println("Enter the right child of " + node.data);
                data = s.nextInt();

                if (data != -1){
                    BinaryTreeNode<Integer> right = new BinaryTreeNode<>(data);
                    node.right = right;
                    q.enqueue(right);
                }
            }
            catch (QueueUnderFlowError e){
                // Never reach here
            }
        }
        return root;
    }

    public static void print(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        QueueUsingLinkedList<BinaryTreeNode<Integer>> q = new QueueUsingLinkedList<>();
        q.enqueue(root);
        while (!q.isEmpty()){
            QueueUsingLinkedList<BinaryTreeNode<Integer>> q1 = new QueueUsingLinkedList<>();
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

                }
            }
            System.out.println();
            q = q1;
        }
    }


    public static Pair<Integer, Integer> diameter(BinaryTreeNode<Integer> root){
        if (root == null){
            Pair<Integer, Integer> p = new Pair<>();
            p.first = 0;
            p.second = 0;
            return p;
        }
        Pair<Integer,Integer> p = diameter(root.left);
        Pair<Integer,Integer> q = diameter(root.right);
        Pair<Integer,Integer> ans = new Pair<>();
        ans.second = Math.max(p.second, q.second) + 1;
        ans.first = Math.max(p.second+ q.second, Math.max(p.first, q.first));
        return ans;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer>root = input();
        print(root);
        Pair<Integer, Integer> p = diameter(root);
        System.out.println("Height is :" + p.second);
        System.out.println("Diameter is :" + p.first);

    }
}
