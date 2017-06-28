package June.week5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Alex_Xie on 26/06/2017.

 https://leetcode.com/problems/3sum/#/description
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        HashMap<Integer, String> map = new HashMap<>() ;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                int sum = nums[i] + nums[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, combine(nums[i], nums[j]));
                }
            }
        }

        for (int num: nums) {

        }


        return null;
    }


    private String combine(int num1, int num2) {

        return "" + num1 + "_" + num2;
    }

    private ArrayList getNums(String str) {
        String[] strList = str.split("_");
        int num1 = Integer.parseInt(strList[0]);
        int num2 = Integer.parseInt(strList[1]);

        ArrayList<Integer> res = new ArrayList<>();
        res.set(0, num1);
        res.set(1, num2);
        return res;
    }

}
