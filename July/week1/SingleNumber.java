package July.week1;

/**
 * Created by Alex_Xie on 01/07/2017.
 Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


 https://leetcode.com/problems/single-number/#/description
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        // use property of xor, any number xor with 0 is still itself
        // every number xor with itself will be 0
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        return xor;
    }

}
