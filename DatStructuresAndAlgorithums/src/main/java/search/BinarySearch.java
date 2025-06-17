package search;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 40};
        System.out.println( "array elements are:"+ Arrays.toString(arr));
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element to search:");

        int x = sc.nextInt();
        int result;
        result = getBinarySearch(x, arr);

        //binary recurssion
        result = getBinarySearchRecurssion(x, arr, 0, arr.length - 1);


    }

    private static int getBinarySearchRecurssion(int x, int[] arr, int left, int right) {


        if (left < right) {
            int mid = (left + right) / 2;
            if (x == arr[mid]) {
                System.out.println("Element found at index: " + mid);
                return mid; // Element found, return index
            } else if (x > arr[mid]) {
                return getBinarySearchRecurssion(x, arr, mid + 1, right); // Search in the right half
            } else if (x < arr[mid]) {
                return getBinarySearchRecurssion(x, arr, left, mid - 1); // Search in the left half
            }
        }

            System.out.println("Element not found in the array.");
            return -1; // Element not found
    }

    private static int getBinarySearch(int x, int[] arr) {

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right )/2;

            // Check if x is present at mid
            if (arr[mid] == x) {
                System.out.println("Element found at index: " + mid);
                return mid; // Element found, return index
            }

            // If x is greater, ignore left half
            if (arr[mid] < x) {
                left = mid + 1;
            } else { // If x is smaller, ignore right half
                right = mid - 1;
            }
        }
        System.out.println( "Element not found in the array.");
        return -1;
    }
}
