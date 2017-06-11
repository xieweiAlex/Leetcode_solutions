package ForestAcademy.week1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alex_Xie on 14/02/2017.

 Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 1² + 9² = 82
 8² + 2² = 68
 6² + 8² = 100
 1² + 0² + 0² = 1

 https://leetcode.com/problems/happy-number/?tab=Description
 // solution
 https://discuss.leetcode.com/topic/25026/beat-90-fast-easy-understand-java-solution-with-brief-explanation/2

 */
public class IsHappyNumber {

    // The idea is to use one hash set to record sum of every digit square of every number occurred. Once the current sum cannot be added to set, return false; once the current sum equals 1, return true;

    // 1. squareSum 2. loop 3. 1
    public boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<Integer>();
        int squareSum, remain;
        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                remain = n%10;
                squareSum += remain*remain;
                n /= 10;
            }
            if (squareSum == 1)
                return true;
            else
                n = squareSum;
        }

        return false;
    }

    public static void main(String[] args) {

    }

}
