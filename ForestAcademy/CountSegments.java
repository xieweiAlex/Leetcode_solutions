package ForestAcademy;

/**
 * Created by Alex_Xie on 17/02/2017.

 Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

 Please note that the string does not contain any non-printable characters.

 Example:

 Input: "Hello, my name is John"
 Output: 5

 https://leetcode.com/problems/number-of-segments-in-a-string/?tab=Description
 */
public class CountSegments {

    public int countSegments(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int res = 0;
        Character pre = ' ';
        for (Character ch: s.toCharArray()) {
            if (ch.equals(' ') && !ch.equals(pre))  {
                res++;
            }
            pre = ch;
        }

        if (pre.equals(' ')) {
            res -= 1;
        }
        return res + 1;
    }

    public int countSegments1(String s) {
        int res=0;
        for(int i=0; i<s.length(); i++)
            if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
                res++;
        return res;
    }

}
