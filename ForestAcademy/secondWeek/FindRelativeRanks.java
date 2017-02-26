package ForestAcademy.secondWeek;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex_Xie on 25/02/2017.
 Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

 Example 1:
 Input: [5, 4, 3, 2, 1]
 Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 For the left two athletes, you just need to output their relative ranks according to their scores.
 Note:
 N is a positive integer and won't exceed 10,000.
 All the scores of athletes are guaranteed to be unique.

 https://leetcode.com/problems/relative-ranks/?tab=Description

 ex:
 Input: [10,3,8,9,4]
 Expect: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]

 */
public class FindRelativeRanks {


    public String[] findRelativeRanks1(int[] nums) {
        if(nums == null || nums.length == 0) return new String[0];

        int n = nums.length;
        String[] result = new String[n];
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < n; ++i){
            map.put(nums[i], i);
        }

//        Comparator<Integer> comparator = (o1, o2) -> o2.compareTo(o1);

        Arrays.sort(nums);
        for( int i = 0; i < n/2; ++i ) {
            int temp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = temp;
        }

        result[map.get(nums[0])] = "Gold Medal";
        if(n > 1) result[map.get(nums[1])] = "Silver Medal";
        if(n > 2) result[map.get(nums[2])] = "Bronze Medal";
        for(int j = 3; j < n; ++j){
            result[map.get(nums[j])] = String.valueOf(j + 1);
        }
        return result;
    }


    public String[] findRelativeRanks(int[] nums) {
        Arrays.sort(nums);

        String[] numStrs = new String[nums.length];
        String[] strs = new String[]{"Gold Medal", "Silver Medal", "Bronze Medal"};

        for (int i = 0; i < nums.length; i ++) {
            if (i <= 2) {
                numStrs[i] = strs[i];
                continue;
            }
            numStrs[i] = "" + nums[i];
        }

        return numStrs;
    }


}
