package July.week1;

/**
 * Created by Alex_Xie on 07/07/2017.

 Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

 The input string does not contain leading or trailing spaces and the words are always separated by a single space.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Could you do it in-place without allocating extra space?
 https://leetcode.com/problems/reverse-words-in-a-string-ii/#/description
 */
public class ReverseWords2 {
    public void reverseWords(char[] s) {
        // 1. reverse the whole string
        reverse(s, 0, s.length-1);

        // 2. reverse each word
        int start = 0;
        for (int i = 0; i <= s.length; i++) {
            if (s[i] == ' ' || i == s.length - 1) {
                reverse(s, start, i-1);
                start = i + 1;
            }
        }
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
