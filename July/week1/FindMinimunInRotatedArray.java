package July.week1;

/**
 * Created by Alex_Xie on 03/07/2017.

 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.


 https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/#/description
 */
public class FindMinimunInRotatedArray {
    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
           int mid = start + (end - start) / 2;
           if (nums[mid] < nums[end]) {
               // the minimum is in the left part
               end = mid;
           } else if (nums[mid] > nums[end]) {
               // the minimum is in the right part
               start = mid;
           }
        }

        System.out.println("start:" + start + " end: " + end);
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }

    public static void main(String args[]) {
        System.out.println(findMin(new int[]{2, 1}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));

    }

}
