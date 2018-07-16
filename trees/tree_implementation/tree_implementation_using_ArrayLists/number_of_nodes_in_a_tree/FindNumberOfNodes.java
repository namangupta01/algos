import java.util.Scanner;

public class FindNumberOfNodes {
    public static TreeNode<Integer> input(){
        Scanner scanner = new Scanner(System.in);
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

    public static int numberOfNodes(TreeNode<Integer> root){
        QueueUsingLinkedList<TreeNode<Integer>> q = new QueueUsingLinkedList<>();
        q.enqueue(root);
        int count = 0;
        while (!q.isEmpty()){
            try {
                TreeNode<Integer> temp = q.dequeue();
                count++;
                for (int i = 0; i < temp.children.size(); i++) {
                    q.enqueue(temp.children.get(i));
                }
            }
            catch (QueueUnderflowError e){
                // Never reach here!!!
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Input tree");
        TreeNode<Integer> root = input();
        print(root);
        System.out.println("Number of nodes are :");
        System.out.println(numberOfNodes(root));
        System.out.println();
    }
}
