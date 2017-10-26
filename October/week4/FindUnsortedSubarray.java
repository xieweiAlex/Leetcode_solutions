package October.week4;

import java.util.Arrays;

/**
 Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

 You need to find the shortest such subarray and output its length.

 Example 1:
 Input: [2, 6, 4, 8, 10, 9, 15]
 Output: 5
 Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 Note:
 Then length of the input array is in range [1, 10,000].
 The input array may contain duplicates, so ascending order here means <=.


 https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/

*/

public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int min = nums[length - 1];
        int max = nums[0];
        int begin = -1, end = -2;
        for (int i = 1; i < length; i++) {
            max = Math.max(max, nums[i]);
            int right = length - 1 - i;
            min = Math.min(min, nums[right]);

            if (nums[i] < max) {
                end = i;
            }
            if (nums[right] > min) {
                begin = right;
            }
        }

        return end - begin + 1;
    }

    public int findUnsortedSubarray1(int[] nums) {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);

        int i = 0, j = nums.length - 1;
        while (i < nums.length && nums[i] == sortedNums[i]) i++;
        while (j > i && nums[j] == sortedNums[j]) j--;

        return j - i + 1;
    }

    public static int findUnsortedSubarray2(int[] nums) {
        int l = 0, r = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (l < r && nums[l] <= nums[l + 1]) {
            l++;
        }

        if (l >= r) return 0;
        while (nums[r] >= nums[r - 1]) {
            r--;
        }

        System.out.println("left is: " + l);
        System.out.println("right is: " + r);
        for (int k = l; k <= r; k++) {
            max = Math.max(nums[k], max);
            min = Math.min(nums[k], min);
        }
        System.out.println("min is: " + min);
        System.out.println("max is: " + max);

        while (l >= 0 && nums[l] > min) {
            l--;
        }
        while (r < nums.length && nums[r] < max) {
            r++;
        }

        System.out.println("reached end left is: " + l);
        System.out.println("reached end right is: " + r);

        // -1 because we need exclude left one and right one, it means:
        // r - 1 - (l + 1) + 1 = r - l - 1
        return (r - l - 1);
    }


    public static void main(String[] args) {

        System.out.println(findUnsortedSubarray2(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarray2(new int[]{1,3,2,2,2}));

    }
}
