public class PrintSubsetsOfArray {

    public static void printSubsets(int input[], int outputSet[]){
        if (input.length == 0){
            for (int i = 0; i < outputSet.length; i++) {
                System.out.print(outputSet[i] + " ");
            }
            System.out.println();
            return;
        }
        int [] smallInput = new int[input.length-1];
        for (int i = 0; i < smallInput.length; i++) {
            smallInput[i] = input[i+1];
        }
        printSubsets(smallInput, outputSet);
        int[] newOutputSet = new int[outputSet.length+1];
        for (int i = 0; i < newOutputSet.length-1; i++) {
            newOutputSet[i] = outputSet[i];
        }
        newOutputSet[newOutputSet.length-1] = input[0];
        printSubsets(smallInput, newOutputSet);
    }

    public static void printSubsets(int input[]) {
        int outputSet[] = new int[0];
        printSubsets(input, outputSet);
    }


    public static void main(String[] args) {
        int [] input = {15, 20, 12};
        printSubsets(input);
    }
}
