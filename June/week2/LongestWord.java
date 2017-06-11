package June.week2;

import java.util.ArrayList;

/**
 * Created by Alex_Xie on 07/06/2017.
 Given a dictionary, find all of the longest words in the dictionary.

 Have you met this question in a real interview? Yes
 Example
 Given

 {
 "dog",
 "google",
 "facebook",
 "internationalization",
 "blabla"
 }
 the longest words are(is) ["internationalization"].

 Given

 {
 "like",
 "love",
 "hate",
 "yes"
 }
 the longest words are ["like", "love", "hate"].
 http://www.lintcode.com/en/problem/longest-words/
 */
public class LongestWord {

    ArrayList<String> longestWords(String[] dictionary) {
        int max = 0;
        ArrayList<String> result = null;

        for (String str : dictionary) {
            if (str.length() > max) {
                max = str.length();
                result = new ArrayList<>();
            }
            if (str.length() == max) {
                result.add(str);
            }
        }

        return result;
    }

    ArrayList<String> longestWords1(String[] dictionary) {
        // write your code here
        int maxLen = 0;
        ArrayList<String> ans = new ArrayList<String>();
        for (int i=0; i<dictionary.length; ++i)
            if (dictionary[i].length()>maxLen) maxLen = dictionary[i].length();
        for (int i=0; i<dictionary.length; ++i)
            if (dictionary[i].length()==maxLen) ans.add(dictionary[i]);
        return ans;
    }


}
