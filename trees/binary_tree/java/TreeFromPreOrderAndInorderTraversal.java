public class TreeFromPreOrderAndInorderTraversal {
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

    public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre, int[] in, int inStart, int preStart, int inEnd, int preEnd){
        if (inStart > inEnd){
            return null;
        }
        int data = pre[preStart];
        int pos = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i]==data){
                pos=i;
                break;
            }
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        System.out.println(data);
        root.left = getTreeFromPreorderAndInorder(pre, in, inStart, preStart+1, pos - 1, pos - inStart + preStart);
        root.right = getTreeFromPreorderAndInorder(pre, in, pos+1, pos-inStart+preStart+1,inEnd,preEnd);
        return root;
    }


    public static BinaryTreeNode<Integer> getTreeFromPreorderAndInorder(int[] pre, int[] in){
        return getTreeFromPreorderAndInorder(pre, in, 0, 0, in.length-1, pre.length-1);
    }

    public static void main(String[] args) {
        int preOrder[] = {1, 2, 3, 4, 15, 5, 6, 7, 8, 10, 9, 12};
        int inOrder[] = {4, 15, 3, 2, 5, 1, 6, 10, 8, 7, 9, 12};
        BinaryTreeNode<Integer> node = getTreeFromPreorderAndInorder(preOrder, inOrder);
        printLevelWise(node);
    }
}
