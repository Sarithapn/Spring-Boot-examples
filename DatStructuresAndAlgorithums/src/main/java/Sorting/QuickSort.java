package Sorting;

import java.util.Arrays;

//Time Complexity: Worst case time complexity is O(N2) and average case time complexity is O(N logN)
public class QuickSort {
	   public static void main(String[] args) {
	    	//order O-square
	        int[] arr = {64, 34, 25, 12, 22, 11, 90};
	        System.out.println("UnSorted array: "+ Arrays.toString(arr));
	        quickSort(arr,0,arr.length-1);
	        System.out.println("Sorted array: "+Arrays.toString(arr));

	    }
	   /* The main function that implements QuickSort()
	      a[] --> Array to be sorted,
	      l  --> Starting index,
	      h  --> Ending index */
		private static void quickSort(int a[], int l, int h) {

			if (l < h)
	        {
	            int pi = partition(a, l, h);

	            // Recursively sort elements before
	            // partition and after partition
	            quickSort(a, l, pi-1);
	            quickSort(a, pi+1, h);
	        }

		}

	   private static int partition(int a[], int low, int high) {
		
		   
		   int pivot = a[high]; 
	        int i = (low-1);
	        for (int j=low; j<high; j++)
	        {
	          
	            // If current element is smaller than or
	            // equal to pivot
	            if (a[j] <= pivot)
	            {
	                i++;

	                int temp = a[i];
	                a[i] = a[j];
	                a[j] = temp;
	            }
	        }

	        int temp = a[i+1];
	        a[i+1] = a[high];
	        a[high] = temp;

	        return i+1;
	   }

}
