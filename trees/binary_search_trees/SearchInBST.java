import java.util.Scanner;

public class SearchInBST {

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

    public static BinaryTreeNode<Integer> searchInBST(BinaryTreeNode<Integer> root , int k){
		if (root == null){
		    return null;
        }
        if (root.data == k){
		    return root;
        }
        else if(root.data > k){
            return searchInBST(root.left, k);
        }
        else {
            return searchInBST(root.right, k);
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        System.out.println("Enter the element you want to search for :");
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        BinaryTreeNode<Integer> node = searchInBST(root, data);
        if (node!=null){
            System.out.println("Node present : True");
            System.out.println("Node data is : " + node.data);
            System.out.println("Node address is :" + node);
        }
        else{
            System.out.println("Node present : False");
        }
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
//        Enter the element you want to search for :
//        2
//        Node present : True
//        Node data is : 2
//        Node address is :BinaryTreeNode@4590c9c3