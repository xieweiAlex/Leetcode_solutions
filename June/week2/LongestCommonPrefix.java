package June.week2;

import java.util.Arrays;

/**
 * Created by Alex_Xie on 10/06/2017.
 *
 Write a function to find the longest common prefix string amongst an array of strings.

 https://leetcode.com/problems/longest-common-prefix/#/description
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);

        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();

        for (int i = 0; i < first.length; i++) {
           if (last.length > i && last[i] == first[i]) {
               sb.append(first[i]);
           } else {
               return sb.toString();
           }
        }

        return sb.toString();
    }

}
