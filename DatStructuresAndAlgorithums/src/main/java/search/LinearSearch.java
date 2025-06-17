package search;

public class LinearSearch {
    public static void main(String[] args) {
         int[] arr = {2,1, 3, 4, 10, 40};
         int x =  3;
            int result = getLinearSearch(arr, x);
    }

    private static int getLinearSearch(int[] arr, int x) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                System.out.println("Element found at index: " + i);
                return i; // Element found, return index
            }
        }
        return -1;
    }

}
