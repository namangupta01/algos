import java.util.Scanner;

public class KeypadSubsequences {

    private static String[] helper(String[] smallAns, char c1, char c2, char c3, char c4){
        int length = smallAns.length;
        if (length == 0){
            String[] s = new String[4];
            s[0] = "" + c1;
            s[1] = "" + c2;
            s[2] = "" + c3;
            s[4] = "" + c4;
            return s;
        }
        String ans[] = new String[5*length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            ans[index] = smallAns[i] + c1;
            index++;
        }

        for (int i = 0; i < length; i++) {
            ans[index] = smallAns[i] + c2;
            index++;
        }

        for (int i = 0; i < length; i++) {
            ans[index] = smallAns[i] + c3;
            index++;
        }

        for (int i = 0; i < length; i++) {
            ans[index] = smallAns[i] + c4;
            index++;
        }
        return ans;
    }


    private static String[] helper(String[] smallAns, char c1, char c2, char c3){
        int length = smallAns.length;
        if (length == 0){
            String[] s = new String[3];
            s[0] = "" + c1;
            s[1] = "" + c2;
            s[2] = "" + c3;
            return s;
        }
        String ans[] = new String[3*length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            ans[index] = smallAns[i] + c1;
            index++;
        }

        for (int i = 0; i < length; i++) {
            ans[index] = smallAns[i] + c2;
            index++;
        }

        for (int i = 0; i < length; i++) {
            ans[index] = smallAns[i] + c3;
            index++;

        }
        return ans;
    }

    private static String[] findKeyWordSubsequences(int n){
        int r = n % 10;
        if (n == 0){
            return new String[0];
        }
        String smallAns[] = findKeyWordSubsequences(n/10);

        switch (r){
            case 0:
                return smallAns;
            case 1:
                return smallAns;
            case 2:
                return helper(smallAns, 'a', 'b', 'c');
            case 3:
                 String s[] = helper(smallAns, 'd', 'e', 'f');
            case 4:
                return helper(smallAns, 'g', 'h', 'i');
            case 5:
                return helper(smallAns, 'j', 'k', 'l');
            case 6:
                return helper(smallAns, 'm', 'n', 'o');
            case 7:
                return helper(smallAns, 'p', 'q', 'r', 's');
            case 8:
                return helper(smallAns, 't', 'u', 'v');
            case 9:
                return helper(smallAns, 'w', 'x', 'y', 'z');
        }
        return new String[0];

    }
    public static void main(String[] args) {
        System.out.println("Enter the number :");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s[] = findKeyWordSubsequences(n);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
