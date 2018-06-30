import java.util.Scanner;

public class NumberOfBalancedBTs {
    public static long countTrees(int height){
        if (height <= 1){
            return 1;
        }
        long x = countTrees(height-1);
        long y = countTrees(height-2);
        return (x*x + 2*x*y);
    }

    public static int countTreesModulo(int height){
        if(height <= 1){
            return 1;
        }
        int x = countTreesModulo(height - 1 );
        int y = countTreesModulo(height - 2 );

        int numberOfTrees = (int)((((long)2*x*y)%1000000007 + ((long)x*x)%1000000007)%1000000007);
        return numberOfTrees;
    }

    public static void main(String[] args) {
        System.out.println("Enter the height of tree : ");
        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        if (height <= 4){
            long numberOfTrees = countTrees(height);
            System.out.println("Number of trees :" +  numberOfTrees);
        }
        else{
            int numberOfTreesModulo =  countTreesModulo(height);
            System.out.println("Number of trees in modulo of 10^9 + 7  : " + numberOfTreesModulo);
        }

    }
}



/*
Explanation:

Balanced trees are those trees whose |left_child_height - right_child_height| <= 1 for
every node in the tree.

In Balanced binary tree of height h there are three possibilities:
1. Both left and right sub tree are of height h-1 => Total trees are : x*x
2. Left tree is of height h-1 and right tree is of height h-2 => Total trees are : x*y
3. Left tree is of height h-2 and right tree is of height h-1 => Total trees are : y*x
Here, x is the total number of binary trees in tree of height h-1 and
y is the total number of binary trees in tree of height h-2.
So, Total no of balanced binary trees of height h is => 2*x*y + x*X
                --------
               |    h   |
                --------
               /        \
             x/          \x
             /            \
         ---------     --------
        |    h-1  |   |   h-1  |
         ---------     --------

                --------
               |    h   |
                --------
               /        \
             x/          \y
             /            \
         ---------     --------
        |  h-1    |   |   h-2  |
         ---------     --------

                --------
               |    h   |
                --------
               /        \
            y /          \ x
             /            \
         ---------     --------
        |    h-2  |   |   h-1  |
         ---------     --------

*/

