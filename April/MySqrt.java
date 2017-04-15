package April;

/**
 * Created by Alex_Xie on 14/04/2017.
 Implement int sqrt(int x).

 Compute and return the square root of x.

 https://leetcode.com/problems/sqrtx/#/description
 */
public class MySqrt {

    public int mySqrt(int x) {
        if (x <= 0) return 0;
        if (x == 1) return 1;

        int left = 1, right = x;
        while (true) {
            // TODO: What's the difference ????
            int mid = left + (right - left)/2;
//            if (mid * mid > x) {
            if (mid > x/mid) {

                    right = mid - 1;
            } else {
//                if ((mid+1)*(mid+1) > x) {
                if (mid + 1 > x/(mid + 1)) {

                    return mid;
                }
                left = mid + 1;
            }
        }
    }



}
