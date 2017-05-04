package firstDay;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex_Xie on 12/01/2017.
 *
 Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int cnt = 0;
        for (Character ch: s.toCharArray()) {
            if (map.get(ch) == null ) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) +1);
                if (map.get(ch) %2 == 0) {
                    cnt++;
                }
            }
        }

        // including "abcba", "abbd" two situation
        if (cnt == s.length()/2) {
            return s.length();
        } else if (cnt != 0) {
            return cnt*2+1;
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("aabb"));
        System.out.println(longestPalindrome("bb"));
    }

}
