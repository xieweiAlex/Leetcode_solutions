package beforeApril.firstDay.ForestAcademy.week2;

/**
 * Created by Alex_Xie on 26/02/2017.
 Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution and you may not use the same element twice.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2

 https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/?tab=Description
 */
public class TwoSum2 {

    public int[] twoSum2(int[] numbers, int target) {
        int[] indices = new int[2];
        int left = 0, right = numbers.length-1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {

                indices[0] = left + 1;
                indices[1] = right + 1;
                return indices;
            } else if(numbers[left] + numbers[right] < target) {

                left++;
            } else {

                right--;
            }
        }
        return indices;
    }
}




