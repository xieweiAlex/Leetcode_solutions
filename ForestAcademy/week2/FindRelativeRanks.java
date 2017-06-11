package ForestAcademy.week2;

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

 */

    /**
     * solution2
     * https://discuss.leetcode.com/topic/77876/easy-java-solution-sorting/
Basically this question is to find out the score -> ranking mapping. The easiest way is to sort those scores in nums. But we will lose their original order. We can create (score , original index) pairs and sort them by score decreasingly. Then we will have score -> ranking (new index) mapping and we can use original index to create the result.

Time complexity: O(NlgN). Space complexity: O(N). N is the number of scores.

Example:

nums[i]    : [10, 3, 8, 9, 4]
pair[i][0] : [10, 3, 8, 9, 4]
pair[i][1] : [ 0, 1, 2, 3, 4]

After sort:
pair[i][0] : [10, 9, 8, 4, 3]
pair[i][1] : [ 0, 3, 2, 4, 1]

     */

public class FindRelativeRanks {

    public String[] findRelativeRanks2(int[] nums) {
        if(nums == null || nums.length == 0) return new String[0];

        int [][] pair = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }

        Arrays.sort(pair, (a, b) -> (b[0] - a[0]));

        String result[] = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {

                result[pair[i][1]] = "Gold Medal";
            } else if (i == 1) {

                result[pair[i][1]] = "Silver Medal";
            } else if (i == 2) {

                result[pair[i][1]] = "Bronze Medal";
            } else {

                result[pair[i][1]] = (i + 1) + "";
            }
        }

        return result;
    }

    // Also we can use an one dimension array. This will save a little bit space but space complexity is still O(n).
    public String[] findRelativeRanks3(int[] nums) {
        Integer[] index = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }

        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));

        String[] result = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[index[i]] = "Gold Medal";
            }
            else if (i == 1) {
                result[index[i]] = "Silver Medal";
            }
            else if (i == 2) {
                result[index[i]] = "Bronze Medal";
            }
            else {
                result[index[i]] = (i + 1) + "";
            }
        }

        return result;
    }


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
