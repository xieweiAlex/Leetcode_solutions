package July.week2;

/**
 * Created by Alex_Xie on 21/02/2017.

 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 click to show more practice.

 More practice:
 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 https://leetcode.com/problems/maximum-subarray/?tab=Description
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;

        // dp[] records the sum of previously nums, if dp[i-1] < 0, then start a new journey
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1]: 0);
            max = Math.max(dp[i], max);
        }


        return max;
    }
}



