package ForestAcademy.week1;

/**
 * Created by Alex_Xie on 14/02/2017.

 Given an integer, write a function to determine if it is a power of three.

 Follow up:
 Could you do it without using any loop / recursion?

 */
public class IsPowerOfThree {

    public boolean isPowerOfThree(int n) {
        if(n>1) {
            while(n%3==0) {
                n /= 3;
            }
        }
        return n==1;
    }

    public boolean isPowerOfThree1(int n) {
        return n>0 && (n==1 || (n%3==0 && isPowerOfThree(n/3)));
    }

    // Or simply hard code it since we know maxPowerOfThree = 1162261467:
    // 3 ^ 19
    public boolean isPowerOfThree2(int n) {
        return n > 0 && (1162261467 % n == 0);
    }
}
