package arrays;
/**
 * LeetCode #121 - Best Time to Buy and Sell Stock
 * Difficulty: Easy
 * Problem: You are given an array prices where prices[i] is the price
 * of a stock on day i. You want to maximize profit by choosing a single
 * day to buy and a different day in the future to sell. Return the
 * maximum profit, or 0 if no profit is possible.
 * Example: prices = [7,1,5,3,6,4] -> 5  (buy at 1, sell at 6)
 * Day 1 of DSA journey
 */
public class BestTimeToBuyAndSell {

    /**
     * Brute force approach: check every possible (buy, sell) pair
     * where the sell day is after the buy day.
     * Time:  O(n^2) - nested loops over n days
     * Space: O(1)   - constant extra space
     */
    public static int maxProfit(int[] prices){
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            for(int j= i+1; j<prices.length; j++){
                int profit = prices[j] - prices[i];
                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * Single-pass approach: as we walk through the array, track
     * the lowest price seen so far and the best profit achievable
     * if we sold on the current day.
     * Key insight: the best profit on day I is
     *   prices[i] - min(prices[0.i-1])
     * Time:  O(n) - single pass
     * Space: O(1) - only two variables tracked
     */
    public static int maxProfitOptimal(int[] prices){
        int maxProfit = 0;
        int miniPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < miniPrice) {
                miniPrice = price;
            }
            int profit = price - miniPrice;
            if (maxProfit < profit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Brute force: " + maxProfit(prices));
        System.out.println("Optimal: " + maxProfitOptimal(prices));
    }
}
