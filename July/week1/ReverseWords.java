package July.week1;

/**
 * Created by Alex_Xie on 07/07/2017.
 Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".
 https://leetcode.com/problems/reverse-words-in-a-string/#/description
 */
public class ReverseWords {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        String result = "";
        for (int i = words.length - 1; i > 0; i--) {
            result += words[i] + " ";
        }

        return result + words[0];
    }

}
