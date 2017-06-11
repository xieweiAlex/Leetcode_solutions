package ForestAcademy.week1;

/**
 * Created by Alex_Xie on 16/02/2017.
 Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

 Note:
 n is positive and will fit within the range of a 32-bit signed integer (n < 231).

 >>
 Example 1:

 Input:
 3

 Output:
 3
 >>

 >>
 Example 2:

 Input:
 11

 Output:
 0
 >>
 Explanation:
 The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

 https://leetcode.com/problems/nth-digit/
 */
public class FindNthDigit_Null {

    public int findNthDigit(int n) {
        if (n < 10) return n;

        /*
        12 == 9 + 10 + 11 + 12

        20 == 9 + 11/2

        * */



        return 0;
    }



}
