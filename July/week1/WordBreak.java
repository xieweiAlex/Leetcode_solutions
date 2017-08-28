package July.week1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex_Xie on 08/07/2017.

 Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 https://leetcode.com/problems/word-break/#/description
 */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null) return false;
        if (s.length() == 0) return true;

        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {

                String sub = s.substring(j, i);
                if (f[j] && wordDict.contains(sub)) {
                    f[i] = true;
                    System.out.println("--contained sub is: " + sub);
                    break;
                }
            }
        }
        return f[s.length()];
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        list.add("complex");

        System.out.println(wordBreak("leetcodecomplex", list));
    }

}
