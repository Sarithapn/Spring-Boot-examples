package Sorting;

import java.util.Arrays;

public class MergeSort {
	// Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    static void mergearray(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        
       int[] larray = Arrays.copyOfRange(arr, 0, n1);
       int[] rarray = Arrays.copyOfRange(arr, m+1, r+1);
       
       System.out.println("left array : \n"+ Arrays.toString(L)+ " \n"+Arrays.toString(larray));
       System.out.println("Right array : \n"+ Arrays.toString(R)+ " \n"+Arrays.toString(rarray));

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void mergesort(int arr[], int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergesort(arr, l, m);
            mergesort(arr, m + 1, r);

            // Merge the sorted halves
            mergearray(arr, l, m, r);
        }
    }

   

    // Driver code
    public static void main(String args[])
    {
    	int[] arr = {64,34,25,12,22,11,90};
		 
		System.out.println("unsorted array : "+Arrays.toString(arr));
		
		mergesort(arr, 0, arr.length-1);
		System.out.println("unsorted array : "+Arrays.toString(arr));
    }
}
