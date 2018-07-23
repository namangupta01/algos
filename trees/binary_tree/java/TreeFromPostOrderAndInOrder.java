public class TreeFromPostOrderAndInOrder {
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

    public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post, int[] in, int inStart, int postStart, int inEnd, int postEnd){
        if (inStart > inEnd){
            return null;
        }
        int data = post[postEnd];
        int pos = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i]==data){
                pos=i;
                break;
            }
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        System.out.println(data);
        root.left = getTreeFromPostorderAndInorder(post, in, inStart, postStart, pos - 1, pos - 1 - inStart + postStart);
        root.right = getTreeFromPostorderAndInorder(post, in, pos+1, pos - inStart + postStart, inEnd, postEnd-1);
        return root;
    }


    public static BinaryTreeNode<Integer> getTreeFromPostorderAndInorder(int[] post, int[] in){
        return getTreeFromPostorderAndInorder(post, in, 0, 0, in.length-1, post.length-1);
    }

    public static void main(String[] args) {
        int postOrder[] = {8, 4, 5, 2, 6, 7, 3, 1};
        int inOrder[] = {4, 8, 2, 5, 1, 6, 3, 7};
        BinaryTreeNode<Integer> node = getTreeFromPostorderAndInorder(postOrder, inOrder);
        printLevelWise(node);
    }
}
