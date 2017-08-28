package September.week1;

/**
 * Created by Alex_Xie on 28/08/2017.
 Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

 Example 1:
 Input: [1,12,-5,-6,50,3], k = 4
 Output: 12.75
 Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 Note:
 1 <= k <= n <= 30,000.
 Elements of the given array will be in the range [-10,000, 10,000].

 https://leetcode.com/problems/maximum-average-subarray-i/description/
 */
public class FindMaxAverage {
    public static double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        long max = sum;

        System.out.println("initial sum is: " + sum);

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];

            System.out.println("sum is: " + sum);
            max = Math.max(max, sum);
        }

        return max / 1.0 / k;
    }


    public static void main(String[] args) {

        System.out.println(findMaxAverage(new int[]{2, 3, 4, 5, 6, 7}, 3));
    }

}
