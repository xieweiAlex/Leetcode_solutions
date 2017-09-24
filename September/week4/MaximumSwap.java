package September.week4;

/*

Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
Note:
The given number is in the range [0, 108]

https://leetcode.com/problems/maximum-swap/description/
solution: https://discuss.leetcode.com/topic/102168/java-simple-solution-o-n-time
* */
public class MaximumSwap {

    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] bucket = new int[10];
        for (int i = 0; i < digits.length; i++) {
            // record the last location of each digit, replace the repeated location of same digit
            bucket[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (bucket[k] > i) {
                    char temp = digits[i];
                    digits[i] = digits[bucket[k]];
                    digits[bucket[k]] = temp;

                    return Integer.valueOf(new String(digits));
                }
            }
        }

        return num;
    }

}
