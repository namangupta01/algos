public class BinarySearchTree {
    public BinaryTreeNode<Integer> root = null;

    public void insertData(int data){
        if (root == null){
            BinaryTreeNode<Integer> node = new BinaryTreeNode<>(data);
            root = node;
            return;
        }
        insertInTree(data, root);
    }

    private void insertInTree(int data, BinaryTreeNode<Integer> node){
        if (data < node.data ){
            if (node.left!=null){
                insertInTree(data, node.left);
            }
            else{
                BinaryTreeNode<Integer> temp = new BinaryTreeNode<>(data);
                node.left = temp;
            }
        }
        else{
            if (node.right!=null){
                insertInTree(data, node.right);
            }
            else{
                BinaryTreeNode<Integer> temp = new BinaryTreeNode<>(data);
                node.right = temp;
            }
        }
    }


    public void printTree(){
        printTreeRecursive(root);
    }

    public void printTreeRecursive(BinaryTreeNode<Integer> root){
        if(root == null){
            return;
        }
        String s = root.data + ":";
        if (root.left!=null){
            s += "L:" + root.left.data + ",";
        }
        if (root.right!=null){
            s += "R:" + root.right.data;
        }
        System.out.println(s);
        printTreeRecursive(root.left);
        printTreeRecursive(root.right);
    }

    public void deleteData(int data){

        root = delete(data, root);
    }

    private BinaryTreeNode<Integer> delete(int data, BinaryTreeNode<Integer> root){
        if (root == null){
            return null;
        }
        if(root.data == data){
            if (root.left != null && root.right != null){
                BinaryTreeNode<Integer> node = findMin(root.right);
                if (node != root.right){
                    node.right = root.right;
                }
                node.left = root.left;
                return node;
            }
            else{
                 if (root.left == null){
                     return root.right;
                 }
                 else {
                     return root.left;
                 }
            }
        }
        else {
            BinaryTreeNode<Integer> lnode = delete(data, root.left);
            BinaryTreeNode<Integer> rnode = delete(data, root.right);
            root.left = lnode;
            root.right = rnode;
            return root;
        }
    }

    private BinaryTreeNode<Integer> findMin(BinaryTreeNode<Integer> node){
        if (node.left == null){
            return node;
        }
        BinaryTreeNode<Integer> node2 = findMin(node.left);
        if (node.left == node2){
            node.left = null;
        }
        return node2;
    }

    public boolean search(int data){
        return search(root, data);
    }
    public boolean search(BinaryTreeNode<Integer> root, int data){
        if (root == null){
            return false;
        }
        if (root.data == data){
            return true;
        }
        Boolean s = search(root.left, data);
        if (s == true){
            return true;
        }
        return search(root.right, data);
    }
}


