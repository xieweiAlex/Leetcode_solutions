package June.week3;

/**
 * Created by Alex_Xie on 12/06/2017.
 Description:

 Count the number of prime numbers less than a non-negative number, n.

 https://leetcode.com/problems/count-primes/#/description
 */
public class CountPrimes {

    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (notPrimes[i] == false) {

                count++;
                for (int j = 2; i * j < n; j++) {
                    notPrimes[i*j] = true;
                }
            }
        }
        return count;
    }

}
