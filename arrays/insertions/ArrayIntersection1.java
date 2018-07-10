public class ArrayIntersection1 {

    public static void intersection(int arr1[], int arr2[]){
        boolean sieve[] = new boolean[arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]){
                    if (sieve[j] == false){
                        sieve[j] = true;
                        break;
                    }
                }
            }
        }
        for (int i=0; i<arr2.length; i++){
            if (sieve[i] == true){
                System.out.println(arr2[i]);
            }
        }
    }

    public static void main(String[] args) {
        int arr1[] = {2, 6, 8, 5, 4, 3, 2};
        int arr2[] = {2, 3, 4, 7, 2};
        intersection(arr1, arr2);
    }
}

// Complexity of finding intersection of two arrays by above algo is O(m*n)