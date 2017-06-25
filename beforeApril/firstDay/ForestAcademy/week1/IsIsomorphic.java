package beforeApril.firstDay.ForestAcademy.week1;

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

        System.out.println(obj.isIsomorphic1("egg", "add"));
        System.out.println(obj.isIsomorphic1("foo", "bar"));

        System.out.println(obj.isIsomorphic1("paper", "title"));

        System.out.println(obj.isIsomorphic1("aba", "baa"));

    }

}
