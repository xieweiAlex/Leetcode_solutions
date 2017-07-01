package June.week5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex_Xie on 29/06/2017.
 Given a digit string, return all possible letter combinations that the number could represent.
 A mapping of digit to letters (just like on the telephone buttons) is given below.

 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.

 https://leetcode.com/problems/letter-combinations-of-a-phone-number/#/description
 */
public class LetterCombinations {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        combination("", digits, 0, result);

        return result;
    }

    private void combination(String prefix, String digits, int offset, List<String> result) {
        if (offset >= digits.length()) {
            result.add(prefix);
            return;
        }

        String letters = KEYS[digits.charAt(offset) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            combination(prefix + letter, digits, offset + 1, result);
        }
    }


/**
 public List<String> letterCombinations(String digits) {
 List<String> res = new ArrayList<>();
 if (digits == null || digits.length() == 0) return res;
 StringBuilder sb = new StringBuilder();
 combine(res, digits, sb, 0);
 return res;
 }

 private void combine(List<String> res, String digits, StringBuilder sb, int posn) {
 if (posn == digits.length()) {
 res.add(sb.toString());
 return;
 }
 String letters = KEYS[digits.charAt(posn) - '0'];
 for (int i = 0; i < letters.length(); i++) {
 int sbLen = sb.length();
 combine(res, digits, sb.append(letters.charAt(i)), posn+1);
 sb.setLength(sbLen);
 }
 }

* */

}
