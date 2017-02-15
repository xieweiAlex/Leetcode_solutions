package ForestAcademy;

/**
 * Created by Alex_Xie on 14/02/2017.
 *
 Given an integer, return its base 7 string representation.

 Example 1:
 Input: 100
 Output: "202"
 Example 2:
 Input: -7
 Output: "-10"
 Note: The input will be in range of [-1e7, 1e7].

 https://leetcode.com/problems/base-7/
 */
public class ConvertToBase7 {

    public String convertToBase7(int num) {
        if (num == 0) return "0";
        String res = "";
        boolean isNeg = num < 0;
        while (num != 0) {
            res = Math.abs((num % 7)) + res;
            num /= 7;
        }
        return isNeg ? "-" + res : res;
    }
    // Integer.toString(num)
//     return Integer.toString(num, 7);


}
