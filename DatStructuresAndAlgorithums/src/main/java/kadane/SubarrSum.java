package kadane;

import java.util.Arrays;

public class SubarrSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int t= 5 ;
        System.out.println(subarraySum(arr,t));

    }
    public static int subarraySum(int[] nums, int k) {
        int count =0;
        int currentsum = 0;
        for(int i =0; i<nums.length;i++){
            currentsum = nums[i]+currentsum;
            if(currentsum == k ||nums[i] == k)
            {
                count++;
            }

            if(currentsum<k)
            {
                currentsum = currentsum;
            }
            else
            {
                currentsum = nums[i];
            }
            System.out.println("sum "+currentsum);

        }

        return count;
    }
}
