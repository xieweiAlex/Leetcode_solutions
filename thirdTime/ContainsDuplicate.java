package thirdTime;

import java.util.*;

/**
 * Created by Alex_Xie on 12/02/2017.
 */
public class ContainsDuplicate {

    public  boolean containsDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums)
            if(!set.add(i))// if there is same
                return true;
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {

        return nums.length != Arrays.stream(nums)
                .distinct()
                .count();
    }

    public boolean containsDuplicate3(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicate4(int[] nums) {
        Arrays.sort(nums);
        for(int ind = 1; ind < nums.length; ind++) {
            if(nums[ind] == nums[ind - 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (!map.containsKey(num)) {
                map.put(num, num);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
