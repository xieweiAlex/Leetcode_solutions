package June.week4;

/**
 * Created by Alex_Xie on 22/06/2017.

 Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.

 https://leetcode.com/problems/move-zeroes/#/description
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int zeroCounter = 0;
        for (int i = 0; i < nums.length; i++) {
            final int num = nums[i];
            if(num == 0){

                zeroCounter++;
            }else if (zeroCounter != 0){
                nums[i-zeroCounter] = num;
                nums[i] = 0;
            }
        }
    }

    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }

    }

}
