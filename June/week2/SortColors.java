package June.week2;

/**
 * Created by Alex_Xie on 11/06/2017.

 Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.

 click to show follow up.

 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

 Could you come up with an one-pass algorithm using only constant space?

 https://leetcode.com/problems/sort-colors/#/description
 */
public class SortColors {

    // 1-pass
    public void sortColors(int[] nums) {
        int p1 = 0, p2 = nums.length -1, index = 0;
        while (index <= p2) {

            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }

            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }

            index++;
        }
    }

    // 2-pass
    public void sortColors1(int[] nums) {

       int count0 = 0, count1 = 0, count2 = 0;
       for (int num: nums) {
           if (num == 0) count0++;
           if (num == 1) count1++;
           if (num == 2) count2++;
       }

       for (int i = 0; i < nums.length; i++) {
           if (i < count0) {
               nums[i] = 0;
           } else if (i < count0 + count1) {
               nums[i] = 1;
           } else {
               nums[i] = 2;
           }
       }

    }

}
