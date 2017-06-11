package June.week2;

import java.util.ArrayList;

/**
 * Created by Alex_Xie on 07/06/2017.

 Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.

 Notice

 You may assume that the array is non-empty and the majority number always exist in the array.

 Have you met this question in a real interview? Yes
 Example
 Given [1, 1, 1, 1, 2, 2, 2], return 1

 http://www.lintcode.com/en/problem/majority-number/
 */
public class MajorityNumber {
    public int majorityNumber(ArrayList<Integer> nums) {

        int count = 0;
        int candidate = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                candidate = nums.get(i);
                count = 1;
            } else if (candidate == nums.get(i)){
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
