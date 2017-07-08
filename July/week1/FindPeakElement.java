package July.week1;

/**
 * Created by Alex_Xie on 03/07/2017.

 A peak element is an element that is greater than its neighbors.

 Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

 The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

 You may imagine that num[-1] = num[n] = -∞.

 For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 https://leetcode.com/problems/find-peak-element/#/description
 */
public class FindPeakElement {

    public static int findPeakElement(int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]) {
                // if right is larger, start from the right
                start = mid + 1;
            } else {
                // if curr larger than right, assign end to curr
                end = mid;
            }
        }

        return nums[start] > nums[end] ? start : end;
    }

    public static void main(String[] args) {

        // [1, 9, 2, 5, 6, 7, 8]
        System.out.println(findPeakElement(new int[]{1, 4, 2, 5, 6, 7, 8}));
    }

}
