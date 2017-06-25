package beforeApril.firstDay;

import java.util.Arrays;

/**
 * Created by Alex_Xie on 12/01/2017.
 *
 Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];

    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 3, 4, 2, 5, 2}));
        System.out.println(majorityElement(new int[]{2, 3, 3, 4, 2, 3, 3}));
    }

}
