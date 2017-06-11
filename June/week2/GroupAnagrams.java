package June.week2;

import java.util.*;

/**
 * Created by Alex_Xie on 09/06/2017.

 Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note: All inputs will be in lower-case.

 https://leetcode.com/problems/group-anagrams/#/description
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();

        List<String> list = new ArrayList<>();
        for (String word: strs) {
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String sortedWord = String.valueOf(letters);
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }
            map.get(sortedWord).add(word);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
