package July.week1;

/**
 * Created by Alex_Xie on 02/07/2017.
 Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 For example:

 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

 Follow up:
 Could you do it without any loop/recursion in O(1) runtime?

 https://leetcode.com/problems/add-digits/#/description
 */
public class AddDigits {

    public int addDigits(int num) {
        if (num < 10) {
            return num;
        } else if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }

    }

    public int addDigits1(int num) {
        if (num < 10) return num;

        while (num > 10) {
            num = sumDigits(num);
        }
        return num;
    }

    private int sumDigits(int n) {
        if (n == 0) return 0;

        return n % 10 + sumDigits(n/10);

    }
}
