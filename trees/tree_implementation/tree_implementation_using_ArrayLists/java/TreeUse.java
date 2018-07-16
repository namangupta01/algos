public class TreeUse {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> node1 = new TreeNode<>(2);
        TreeNode<Integer> node2 = new TreeNode<>(3);
        TreeNode<Integer> node3 = new TreeNode<>(4);
        TreeNode<Integer> node4 = new TreeNode<>(5);
        TreeNode<Integer> node5 = new TreeNode<>(6);
        TreeNode<Integer> node6 = new TreeNode<>(7);
        TreeNode<Integer> node7 = new TreeNode<>(8);
        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);
        node2.children.add(node5);
        node3.children.add(node6);
        node3.children.add(node7);
        System.out.println();
    }
}
