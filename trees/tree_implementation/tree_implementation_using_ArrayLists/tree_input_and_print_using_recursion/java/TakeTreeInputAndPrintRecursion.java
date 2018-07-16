import java.util.Scanner;

public class TakeTreeInputAndPrintRecursion {

    public static TreeNode<Integer> input(Scanner s){
        System.out.println("Enter the node data");
        TreeNode<Integer> root = new TreeNode<>(s.nextInt());
        System.out.println("Enter the number of childern of " + root.data);
        int number = s.nextInt();
        for (int i = 0; i < number; i++) {
            root.children.add(input(s));
        }
        return root;
    }

    public static void print(TreeNode<Integer> root){
        System.out.print(root.data + ": ");
        for (int i = 0; i < root.children.size(); i++) {
            System.out.print(root.children.get(i).data + ", ");
        }
        System.out.println();
        for (int i = 0; i < root.children.size(); i++) {
            print(root.children.get(i));
        }
    }

    public static void main(String[] args) {
        System.out.println("Input tree");
        Scanner s = new Scanner(System.in);
        TreeNode<Integer> root = input(s);
        print(root);
        System.out.println();
    }
}

// Sample Input Output
//        Enter the node data
//        1
//        Enter the number of childern of 1
//        3
//        Enter the node data
//        2
//        Enter the number of childern of 2
//        1
//        Enter the node data
//        5
//        Enter the number of childern of 5
//        2
//        Enter the node data
//        10
//        Enter the number of childern of 10
//        0
//        Enter the node data
//        11
//        Enter the number of childern of 11
//        0
//        Enter the node data
//        3
//        Enter the number of childern of 3
//        1
//        Enter the node data
//        6
//        Enter the number of childern of 6
//        2
//        Enter the node data
//        8
//        Enter the number of childern of 8
//        0
//        Enter the node data
//        9
//        Enter the number of childern of 9
//        0
//        Enter the node data
//        4
//        Enter the number of childern of 4
//        1
//        Enter the node data
//        7
//        Enter the number of childern of 7
//        0
//
//        Output:
//        1: 2, 3, 4,
//        2: 5,
//        5: 10, 11,
//        10:
//        11:
//        3: 6,
//        6: 8, 9,
//        8:
//        9:
//        4: 7,
//        7: 
