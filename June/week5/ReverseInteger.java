package June.week5;

/**
 * Created by Alex_Xie on 27/06/2017.
 */
public class ReverseInteger {

    public int reverse(int x) {
        int sign = x > 0 ? 1 : -1;

        int posiX = Math.abs(x);
        int result = 0;
        while (posiX != 0) {
            int tail = posiX % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            posiX /= 10;
        }

        // 123 -> 321
        return result * sign;
    }
}
