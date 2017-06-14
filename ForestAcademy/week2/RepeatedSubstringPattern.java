package ForestAcademy.week2;

/**
 * Created by Alex_Xie on 25/02/2017.
 Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

 Example 1:
 Input: "abab"

 Output: True

 Explanation: It's the substring "ab" twice.
 Example 2:
 Input: "aba"

 Output: False
 Example 3:
 Input: "abcabcabcabc"

 Output: True

 Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)

 https://leetcode.com/problems/repeated-substring-pattern/?tab=Description
 1. The length of the repeating substring must be a divisor of the length of the input string
 2. Search for all possible divisor of str.length, starting for length/2
 3. If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
 4. If the repeated substring is equals to the input str return true

 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern2(String s) {
        int l = s.length();
        for (int i = l/2; i >= 1; i--) {
            if (l % i == 0) {
               int m = l / i;
               String subStr = s.substring(0, i);
               StringBuilder sb = new StringBuilder();
               for (int j = 0; j < m; j++) {
                   sb.append(subStr);
               }

               if (sb.toString().equals(s)) {
                   return true;
               }
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern1(String s) {
        int l = s.length();
        for (int i = l/2; i >= 1; i--) {
            if (l % i == 0) {
                int m = l / i;
                String subStr = s.substring(0, i);
                int j;
                for (j = 1; j < m; j++) {
                    if (!subStr.equals(s.substring(j*i, i+j*i))) {
                        break;
                    }
                }
                if (j == m)  return true;
            }
        }
        return false;
    }

}
