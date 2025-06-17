	package Sorting;

import java.util.Arrays;

public class SelectionSort {
	// order = O(n- square)
	public static void main(String args[])
	{
		int[] arr = {64,34,25,12,22,11,90};
		 
		System.out.println("unsorted array : "+Arrays.toString(arr));
		
		selectionSort(arr);
		System.out.println("unsorted array : "+Arrays.toString(arr));
		
			
	}

	private static void selectionSort(int[] arr) {
		int size = arr.length;
		int minindex =-1;
		//on every iteration gets lower element first
		for(int i =0; i<size-1; i++)
		{
			 minindex = i;
			for (int j=i+1;j<size-1;j++) {
			  if(arr[minindex]>arr[j])
			  {
				  minindex = j;
			  }
				
			}
			int temp = arr[minindex];
			arr[minindex] = arr[i];
			arr[i] = temp;
			
		}
		
	}

	
	

}
