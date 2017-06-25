package June.week3;

/**
 * Created by Alex_Xie on 15/06/2017.
 Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

 Your algorithm should run in O(n2) complexity.

 Follow up: Could you improve it to O(n log n) time complexity?

 https://leetcode.com/problems/longest-increasing-subsequence/#/description
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int[] lens = new int[nums.length];
        for (int i = 0; i < lens.length; i++) {
            lens[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {
                    if (lens[j] + 1 > lens[i]) {
                        lens[i] = lens[j] + 1;
                    }
                }
            }
        }

        int longest = 0;
        for (int len: lens) {
            longest = longest > len ? longest : len;
        }


//        Arrays.binarySearch()
        return longest;
    }

}
