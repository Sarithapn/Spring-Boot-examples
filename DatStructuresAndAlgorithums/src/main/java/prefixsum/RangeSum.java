package prefixsum;

import java.util.Arrays;

public class RangeSum {

    public static void main(String[] args) {
        int[] sum = {-2, 0, 3, -5, 2, -1};
        int left = 0;
        int right = 5;
        System.out.println(sumRange(sum, left, right));
        NumArray(sum, left, right);

    }

    private static int sumRange(int[] sum, int left, int right) {
        int n = sum.length;
        int prefixsum[] = new int[n];
        int indexsum = 0;
        for (int i = 0; i < n; i++) {
        indexsum = indexsum+sum[i];
        prefixsum[i] =  indexsum;
        }
        System.out.println(Arrays.toString(prefixsum));
if(left ==0)
{
    return prefixsum[right];
}
        return prefixsum[right]-prefixsum[left-1];
    }

    // Constructor that computes the cumulative sum of the numbers array.
    public static void NumArray(int[] nums,int left, int right) {
        int n = nums.length;
        int[] sumArray;
        sumArray = new int[n + 1]; // Initialized with an extra element to handle the sum from 0 to ith index.

        // Accumulate the sum of elements so that sumArray[i] holds the sum up to nums[i-1].
        for (int i = 0; i < n; i++) {
            sumArray[i + 1] = sumArray[i] + nums[i];
        }
        System.out.println(Arrays.toString(sumArray));
        System.out.println(sumArray[right + 1] - sumArray[left]);
    }

//    // Method to compute sum of elements within the range [left, right] both inclusive.
//    public static int sumRange1(int left, int right) {
//        // The sum of elements in range [left, right] is computed by subtracting the cumulative sum up to 'left' from the sum up to 'right + 1'.
//       // return sumArray[right + 1] - sumArray[left];
//    }
}