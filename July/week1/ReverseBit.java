package July.week1;

/**
 * Created by Alex_Xie on 07/07/2017.
 Reverse bits of a given 32 bits unsigned integer.

 For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

 Follow up:
 If this function is called many times, how would you optimize it?

 https://leetcode.com/problems/reverse-bits/#/description
 */
public class ReverseBit {

    public int reverseBits(int n) {

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1; // CATCH: must do unsigned shift
            if (i < 31) {
                result <<= 1; // CATCH: for last digit, don't shift!
            }
        }

        return result;
    }

}
