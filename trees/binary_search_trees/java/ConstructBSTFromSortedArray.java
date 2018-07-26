public class ConstructBSTFromSortedArray {

    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int i, int j){
        if (i > j){
            return null;
        }
        int mid = (j+i)/2;
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(arr[mid]);
        node.left = SortedArrayToBST(arr, i, mid-1);
        node.right = SortedArrayToBST(arr, mid + 1, j);
        return node;
    }

    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr){
        return SortedArrayToBST(arr, 0, arr.length-1);
    }

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

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        printLevelWise(SortedArrayToBST(sortedArray));
    }
}
