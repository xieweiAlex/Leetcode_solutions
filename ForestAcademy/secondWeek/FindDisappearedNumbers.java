package ForestAcademy.secondWeek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Alex_Xie on 26/02/2017.
 Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]

 https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/?tab=Description
 */
public class FindDisappearedNumbers {

    //     [4,3,2,7,8,2,3,1]
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> ret = new ArrayList();

        for (int i = 0; i < nums.length; i++ ) {
            int val = Math.abs(nums[i])-1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 ) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    // this is wrong
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums.length == 0) {
            return new LinkedList<>();
        } else if (nums.length == 1) {
            return new LinkedList<>(Arrays.asList(nums[0]));
        }

        Arrays.sort(nums);
        List<Integer> list = new LinkedList<>();
        int m = 0;
        for (int i = 0; i < nums.length; i ++ ) {
            if (i != 0 && nums[i] == nums[i-1]) {
                m--;
                continue;
            }

            int num = i + 1;

            System.out.println(num);
            System.out.println(nums[i]);
            System.out.println("--------");

            if (num + m< nums[i]) {
                m++;
                list.add(num);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        // 4,3,2,7,8,2,3,1
        // 1,2,3,4,7,8
        // 5,6
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }


}
