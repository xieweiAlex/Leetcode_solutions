package ForestAcademy.week1;

/**
 * Created by Alex_Xie on 19/02/2017.

 Determine whether an integer is a palindrome. Do this without extra space.

 https://leetcode.com/problems/palindrome-number/?tab=Description
 */
public class IsPalindrome {

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;

        int rev = 0;
        while (x > rev) {
            rev = rev*10 + x%10;
            x = x/10;
        }

        // x==rev is for the scenery of even digits, x==rev/10 for the odd digits.
        return (x == rev || x == rev/10);
    }

    static void main(String[] args) {

    }

}




