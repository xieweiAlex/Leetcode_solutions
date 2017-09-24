package September.week1;

/*
*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
https://leetcode.com/problems/subarray-sum-equals-k/description/
*/

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int result = 0;
        // the reason why use Map cause preSum won't keeps increasing when has negative
        Map<Integer, Integer> preSum = new HashMap<>();
        // in case meet value k in array
        preSum.put(0, 1);

        for (int n: nums) {
            sum += n;
            if (preSum.containsKey(sum - k)) {
               result += preSum.get(sum - k);
            }

            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

}
