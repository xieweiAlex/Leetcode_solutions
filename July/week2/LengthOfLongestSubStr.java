package July.week2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex_Xie on 09/07/2017.
 Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 https://leetcode.com/problems/longest-substring-without-repeating-characters/#/description
 */
public class LengthOfLongestSubStr {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int j = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                j = Math.max(j, map.get(ch) + 1);
            }
            map.put(ch, i);
            max = Math.max(max, i-j+1);
        }

        return max;
    }
}
