package November.week1;

/*

 * explain:
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]

 * url:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/

 * solution:
 // 0, 1
 https://discuss.leetcode.com/topic/31349/7-line-java-only-consider-sell-and-cooldown
 // 2
https://discuss.leetcode.com/topic/30680/share-my-dp-solution-by-state-machine-thinking
*/

public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int profit1 = 0, profit2 = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit1Copy = profit1;
            profit1 = Math.max(profit1 + prices[i] - prices[i - 1], profit2);
            profit2 = Math.max(profit1Copy, profit2);
        }

        return Math.max(profit1, profit2);
    }

    public int maxProfit1(int[] prices) {
        if (prices.length <= 1) return 0;

        int[] profit1 = new int[prices.length];
        int[] profit2 = new int[prices.length];
        int i = 1;
        for (; i < prices.length; i++) {
            profit1[i] = Math.max(profit1[i-1] + prices[i] - prices[i-1], profit2[i-1]);
            profit2[i] = Math.max(profit1[i-1], profit2[i-1]);
        }

        return Math.max(profit1[i], profit2[i]);
    }

    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) return 0;

        // just cool down
        int[] s0 = new int[prices.length];
        // just bought
        int[] s1 = new int[prices.length];
        // just sold
        int[] s2 = new int[prices.length];

        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;

        int i = 1;
        for (; i < prices.length; i++) {
            // Stay at s0, or rest from s2
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            // Stay at s1, or buy from s0
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
            // Only one way from s1
            s2[i] = s1[i - 1] + prices[i];
        }

        return Math.max(s0[i - 1], s2[i - 1]);
    }

}
