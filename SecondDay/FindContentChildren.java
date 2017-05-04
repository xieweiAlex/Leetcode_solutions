package SecondDay;

import java.util.Arrays;

/**
 * Created by Alex_Xie on 14/01/2017.
 *
 Assume you are an awesome parent and want to give your children some cookies. But,
 * you should give each child at most one cookie.
 * Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with;
 * each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content.
 * Your goal is to maximize the number of your content children and output the maximum number.

 Example 1:
 Input: [1,2,3], [1,1]

 Output: 1

 Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
 And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
 You need to output 1.
 */
public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        // children
        int i = 0;
        // cookies
        for(int j = 0;i < g.length && j < s.length;j++) {
            if (j >= g.length - 1) {
               break;
            }
            if(g[i]<=s[j]) {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {

    }

}
