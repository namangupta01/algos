import java.util.Scanner;

public class CountLeafNodes {
    public static Scanner scanner = new Scanner(System.in);
    public static TreeNode<Integer> input(){

        System.out.println("Enter the node data");
        TreeNode<Integer> root = new TreeNode<>(scanner.nextInt());
        QueueUsingLinkedList<TreeNode<Integer>> q = new QueueUsingLinkedList<>();
        q.enqueue(root);
        while(!q.isEmpty()){
            try {
                TreeNode<Integer> temp = q.dequeue();
                System.out.println("Enter number of children of " + temp.data + "th node");
                int number = scanner.nextInt();
                for (int i = 0; i < number; i++) {
                    System.out.println("Enter " + (i+1) + "th child of " + temp.data);
                    TreeNode<Integer> child = new TreeNode<>(scanner.nextInt());
                    temp.children.add(child);
                    q.enqueue(child);
                }
            }
            catch (QueueUnderflowError e){
                // Never reach here!!!!!
                return null;
            }
        }

        return root;
    }

    public static void print(TreeNode<Integer> root){
        QueueUsingLinkedList<TreeNode<Integer>> q = new QueueUsingLinkedList<>();
        q.enqueue(root);
        while (!q.isEmpty()){
            QueueUsingLinkedList<TreeNode<Integer>> q1 = new QueueUsingLinkedList<>();
            try {
                while(!q.isEmpty()){
                    TreeNode<Integer> node = q.dequeue();
                    System.out.print(node.data+ " ");
                    for (int i = 0; i < node.children.size(); i++) {
                        q1.enqueue(node.children.get(i));
                    }
                }
                System.out.println();

                q = q1;
            }
            catch (QueueUnderflowError e){
                // Never Reach Here
            }
        }
    }

    public static void printLeafNodes(TreeNode<Integer> root){
        if (root == null){
            return;
        }
        if (root.children.size()==0){
            System.out.println(root.data);
            return;
        }
        for (int i = 0 ; i < root.children.size();  i++) {
            printLeafNodes(root.children.get(i));
        }
    }


    public static void main(String[] args) {
        System.out.println("Input tree");
        TreeNode<Integer> root = input();
        print(root);
        System.out.println();
        System.out.println("Leaf nodes are : ");
        printLeafNodes(root);
    }
}

//    Input tree
//        Enter the node data
//        1
//        Enter number of children of 1th node
//        3
//        Enter 1th child of 1
//        2
//        Enter 2th child of 1
//        3
//        Enter 3th child of 1
//        4
//        Enter number of children of 2th node
//        1
//        Enter 1th child of 2
//        5
//        Enter number of children of 3th node
//        1
//        Enter 1th child of 3
//        6
//        Enter number of children of 4th node
//        1
//        Enter 1th child of 4
//        7
//        Enter number of children of 5th node
//        2
//        Enter 1th child of 5
//        10
//        Enter 2th child of 5
//        11
//        Enter number of children of 6th node
//        2
//        Enter 1th child of 6
//        8
//        Enter 2th child of 6
//        9
//        Enter number of children of 7th node
//        0
//        Enter number of children of 10th node
//        0
//        Enter number of children of 11th node
//        0
//        Enter number of children of 8th node
//        0
//        Enter number of children of 9th node
//        0
//        1
//        2 3 4
//        5 6 7
//        10 11 8 9
//
//        Leaf nodes are :
//        10
//        11
//        8
//        9
//        7
