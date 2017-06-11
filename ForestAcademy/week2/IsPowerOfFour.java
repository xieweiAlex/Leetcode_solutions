package ForestAcademy.week2;

/**
 * Created by Alex_Xie on 24/02/2017.

 Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

 Example:
 Given num = 16, return true. Given num = 5, return false.

 Follow up: Could you solve it without loops/recursion?

 https://leetcode.com/problems/power-of-four/?tab=Description
 */
public class IsPowerOfFour {

    public static boolean isPowerOfFour(int num) {
        if (num == 1) {
            return true;
        }
        while (num > 4) {
            if (num %4 != 0) {
                return false;
            }
            num /= 4;
        }

        return num == 4;
    }

    // TODO: didn't get it why num & (num-1) verify power of 2
    public static boolean isPowerOfFour1(int num) {
        return (num&(num-1))==0 && num>0 && (num-1)%3==0;
    }

    // TODO: don't know
    public boolean isPowerOfFour2(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour1(16));
        System.out.println(isPowerOfFour(117));

    }


}
