package thirdTime;

import java.util.Arrays;

/**
 * Created by Alex_Xie on 12/02/2017.
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {

        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] < nums[i+1] -1 ) {
                return nums[i] + 1;
            }
        }
        return nums[nums.length-1]+1;
    }

    public static int missingNumber1(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++)
            sum += i - nums[i];
        return sum;
    }

    public static void main(String[] args) {

//        MissingNumber object = new MissingNumber();
//        System.out.println(object.missingNumber(new int[]{1, 2, 3, 4, 6}));

        System.out.println(missingNumber1(new int[]{0, 1, 2, 4, 5, 6}));

    }
}
