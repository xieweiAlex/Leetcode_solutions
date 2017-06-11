package ForestAcademy.week2;

/**
 * Created by Alex_Xie on 24/02/2017.
 You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 https://leetcode.com/problems/house-robber/?tab=Description
 */
public class Rob {

   public int rob_1(int[] nums) {
       int a = 0, b = 0;
       for (int i = 0; i < nums.length; i ++) {
           if (i %2 == 0) {
               a = Math.max(a+nums[i], b);
           } else {
               b = Math.max(b+nums[i], a);
           }
       }

       return Math.max(a, b);
   }

   public int rob_2(int[] nums) {

       int[] array = new int[nums.length];
       array[0] = nums[0];
       array[1] = Math.max(nums[0], nums[1]);

       for (int i = 2; i < nums.length; i++) {
           array[i] = Math.max(nums[i] + array[i-2], array[i-1]);
       }

       return array[nums.length-1];
   }


    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        } else if(length == 1) {
            return nums[0];
        } else if(length == 2) {
            return Math.max(nums[length-2], nums[length-1]);
        } else if(length == 3) {
            return cacl3Elements(nums);
        }

        // [1,2,1,0]  expected: 2, result: 3
        // [1,1,1,1]  Output: 1, expected: 2
        int i = 0;
        int result = 0;
        while (i < length - 3) {
            if (nums[i] + nums[i+2] >= nums[i+1] + nums[i+3]) {
                result += nums[i];
            } else {
                i += 1;
                result += nums[i];
            }
            i += 2;
        }

        // length-3, length-2, length-1
         if(i == length -3){
            int max = cacl3Elements(nums);
            result += max;
        } else if(i == length - 2) {
             result += Math.max(nums[length-2], nums[length-1]);
        } else if(i == length -1) {
             result += nums[length-1];
         }

        return result;
    }

    private int cacl3Elements(int[] nums) {
        int length = nums.length;
        int num3 = nums[length-3];
        int num2 = nums[length-2];
        int num1 = nums[length-1];
        if (num3 + num1 > num2) {
            return num3 + num1;
        } else {
            return Math.max(nums[length-3], Math.max(nums[length-2], nums[length-1]));
        }
    }

}
