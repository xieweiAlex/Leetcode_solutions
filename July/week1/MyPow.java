package July.week1;

/**
 * Created by Alex_Xie on 03/07/2017.
 */
public class MyPow {

    double myPow(double x, int n) {
        if (n == 0) return 1;

        double t = myPow(x, n / 2);
        if (n % 2 != 0) {
            return n < 0 ?  (1/x) * t * t : x * t * t;
        }
        return t * t;
    }

}
