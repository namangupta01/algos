import java.util.Scanner;

public class Subsequences {

    private static String[] subSequences(String str) {
        if(str.length() == 1){
            String[] s = new String[2];
            s[0] = "";
            s[1] = str;
            return s;
        }
        String[] s = subSequences(str.substring(1));
        String[] newAns = new String[s.length*2];
        for (int i = 0; i < s.length; i++){
            newAns[i] = s[i];
        }
        for (int i = s.length; i<newAns.length; i++){
            newAns[i] = str.charAt(0) + s[i - s.length];
        }
        return newAns;
    }


    public static void main(String[] args) {
        System.out.println("Enter the string whose sub-sequences is to be found : ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String [] ans = subSequences(str);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
