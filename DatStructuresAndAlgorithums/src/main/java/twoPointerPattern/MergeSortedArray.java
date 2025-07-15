package twoPointerPattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
 representing the number of elements in nums1 and nums2 respectively.
Merge nums1 and nums2 into a single array sorted in non-decreasing order.
The final sorted array should not be returned by the function, but instead be stored inside
the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements
denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
*/
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int f = m-1;
        int s = n-1;
        int e = m+n-1;
        while(f>=0 && s>=0 && e>=0)
        {
            if(nums1[f]>=nums2[s]){
                nums1[e] = nums1[f];
                f--;
            }
            else
            {
                nums1[e] = nums2[s];
                s--;
            }
            e--;
        }
        while(s>=0)
        {
            nums1[e] = nums2[s];
            s--;
            e--;
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1,m,nums2,n);
        int[] sum = {1, 2, 3, 5, 6};
        int targer= 10 ;
        System.out.println(Arrays.toString( twoSum(sum,targer)));

    }

    public static int[] twoSum(int[] numbers, int target) {

        Map<Integer, Integer> indexValue = new HashMap<Integer, Integer>();
        boolean found = false;
        int i =1;
        indexValue.put(numbers[0],0);
        while(i<numbers.length)
        {
            if(indexValue.containsKey(target-numbers[i]))
            {
                return new int[]{i,indexValue.get(target-numbers[i])};
            }
            else
                indexValue.put(numbers[i],i);
            i++;
        }

        return new int[2];

    }



    public static int maxArea(int[] height) {
        int max =0;
        int l = 0;
        int r = height.length -1;
        while(l<=r)
        {
            int area =Math.min(height[l],height[r]) * r-l;
            max = Math.max(area,max);
            if(height[l]<height[l+1])
            {
                l++;
            }
            else
                r--;

        }


        return max;
    }
}
