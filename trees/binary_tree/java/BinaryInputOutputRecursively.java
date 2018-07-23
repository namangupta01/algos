import java.util.Scanner;

public class BinaryInputOutputRecursively {

    public static BinaryTreeNode<Integer> input(Scanner s){
        System.out.println("Enter the node : ");
        int data = s.nextInt();
        if (data == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        root.left = input(s);
        root.right = input(s);
        return root;
    }

    public static void printRecursively(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        String s = root.data + "";
        if (root.left!=null){
            s = s + ": L" + root.left.data;
        }
        if (root.right!=null){
            s = s + ": R" + root.right.data;
        }
        System.out.println(s);
        printRecursively(root.left);
        printRecursively(root.right);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BinaryTreeNode<Integer> root = input(s);
        printRecursively(root);
    }
}
