import java.util.Scanner;

public class BSTUse {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner s = new Scanner(System.in);
        int choice, input;
        while (true) {
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    input = s.nextInt();
                    bst.insertData(input);
                    break;
                case 2:
                    input = s.nextInt();
                    bst.deleteData(input);
                    break;
                case 3:
                    input = s.nextInt();
                    System.out.println(bst.search(input));
                    break;
                default:
                    bst.printTree();
                    return;
            }

        }
    }
}