package arrays;
/**
 * LeetCode #121 - Best Time to Buy and Sell Stock
 * Day 1 of DSA journey
 */
public class BestTimeToBuyAndSell {

    //Time complexity: O(n²), Space: O(1)
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

    // Single pass - Time: O(n), Space: O(1)
    public static int maxProfitOptimal(int[] prices){
        int maxProfit = 0;
        int miniPrice = Integer.MAX_VALUE;
        for (int i=0; i<prices.length; i++){
            if(prices[i] < miniPrice){
                miniPrice = prices[i];
            }
            int profit = prices[i] - miniPrice;
            if(maxProfit < profit){
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
