package ForestAcademy.firstWeek;

/**
 * Created by Alex_Xie on 15/02/2017.

 Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

 For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

 https://leetcode.com/problems/number-of-1-bits/

 */
public class HammingWeight {

    // 17
    // 17,8,1   8,4,0   4,2,0   2,0,1
    public int hammingWeight(int n) {

        int res = 0;
        while (n >= 1) {
            if (n % 2 != 0) {
                res++;
            }
            n /= 2;
        }
        return res;
    }

    public static int hammingWeight1(Integer n) {
        int ones = 0;
        while(n!=0) {
            ones = ones + (n & 1);
            n = n>>>1;
        }
        return ones;
    }

    public static void main(String[] args) {
        HammingWeight obj = new HammingWeight();
        System.out.println(obj.hammingWeight(11));
        System.out.println(obj.hammingWeight(8));
        System.out.println(obj.hammingWeight(2));
    }


}
