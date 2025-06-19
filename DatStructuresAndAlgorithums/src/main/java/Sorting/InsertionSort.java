package Sorting;

import java.util.Arrays;

//Best Case: O(n) - When the array is already sorted.
//Average Case: O(n^2) - When the array is randomly ordered.
//Worst Case: O(n^2) - When the array is sorted in reverse order. 
public class InsertionSort {
	   public static void main(String[] args) {
	    	//order O-square
	        int[] arr = {64, 34, 25, 12, 22, 11, 90};
	        System.out.println("UnSorted array: "+ Arrays.toString(arr));
	        insertionSort(arr);
	        System.out.println("Sorted array: "+Arrays.toString(arr));

	    }

	    public static void insertionSort(int[] arr) {
	        int n = arr.length;
	        for (int i = 1; i < n; ++i) {
	            int key = arr[i];
	            int j = i - 1;

	            while (j >= 0 && arr[j] > key) {
	                arr[j + 1] = arr[j];
	                j = j - 1;
	            }
	            arr[j + 1] = key;
	        }
	    }
}
