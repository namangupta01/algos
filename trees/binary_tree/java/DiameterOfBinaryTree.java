import java.util.Scanner;

public class DiameterOfBinaryTree {

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

    public static int Diameter(BinaryTreeNode<Integer> node){
        if (node == null){
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int diameter = leftHeight + rightHeight;
        int diameter1 = Diameter(node.left);
        int diameter2 = Diameter(node.right);
        return Math.max(diameter, Math.max(diameter1, diameter2));
    }

    public static int height(BinaryTreeNode<Integer> node){
        if (node == null){
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    public static void main(String[] args) {
        BinaryTreeNode<Integer>root = input();
        print(root);
        System.out.print("Diameter is :");
        System.out.println(Diameter(root));

    }
}
