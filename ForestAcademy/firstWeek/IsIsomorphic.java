package ForestAcademy.firstWeek;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex_Xie on 16/02/2017.

 Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 Note:
 You may assume both s and t have the same length.

 https://leetcode.com/problems/isomorphic-strings/
 */
public class IsIsomorphic {

    // didn't work, failed by postion
    public boolean isIsomorphic(String s, String t) {

        Map<Character, Integer> map1 = new HashMap<>() ;
        Map<Character, Integer> map2 = new HashMap<>() ;

        for (int i = 0; i < s.length(); i ++) {
            Character ch = s.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 1) + 1);
        }
        for (int i = 0; i < t.length(); i ++) {
            Character ch = t.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 1) + 1);
        }

        if (map1.keySet().size() != map2.keySet().size()) {
            return false;
        }

        for (Integer val: map1.values()) {
            if (!map2.values().contains(val)) {
                return false;
            }
        }

        return true;
    }

    public boolean isIsomorphic1(String s, String t) {

        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (m1[ s.charAt(i) ] != m2[t.charAt(i)] ) return false;

            m1[ s.charAt(i)] = i + 1;
            m2[ t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        IsIsomorphic obj = new IsIsomorphic();

        System.out.println(obj.isIsomorphic("egg", "add"));
        System.out.println(obj.isIsomorphic("foo", "bar"));

        System.out.println(obj.isIsomorphic("paper", "title"));

        System.out.println(obj.isIsomorphic("aba", "baa"));

    }

}
