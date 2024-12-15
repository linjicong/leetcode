//You are given an array prices where prices[i] is the price of a given stock
//on the iᵗʰ day.
//
// Find the maximum profit you can achieve. You may complete at most two
//transactions.
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you
//must sell the stock before you buy again).
//
//
// Example 1:
//
//
//Input: prices = [3,3,5,0,0,3,1,4]
//Output: 6
//Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit =
//3-0 = 3.
//Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
//
//
// Example 2:
//
//
//Input: prices = [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit =
//5-1 = 4.
//Note that you cannot buy on day 1, buy on day 2 and sell them later, as you
//are engaging multiple transactions at the same time. You must sell before buying
//again.
//
//
// Example 3:
//
//
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transaction is done, i.e. max profit = 0.
//
//
//
// Constraints:
//
//
// 1 <= prices.length <= 10⁵
// 0 <= prices[i] <= 10⁵
//
//
// Related Topics 数组 动态规划 👍 1772 👎 0

//Best Time to Buy and Sell Stock III
public class Q123_BestTimeToBuyAndSellStockIii{
    public static void main(String[] args) {
        Solution solution = new Q123_BestTimeToBuyAndSellStockIii().new Solution();
        // 测试用例
        int[] prices1 = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(solution.maxProfit(prices1)); // 输出 6

        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println(solution.maxProfit(prices2)); // 输出 4

        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit(prices3)); // 输出 0

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int maxProfit(int[] prices) {
            if (prices == null || prices.length < 2) {
                return 0;
            }

            int n = prices.length;
            int firstBuy = Integer.MIN_VALUE;
            int firstSell = 0;
            int secondBuy = Integer.MIN_VALUE;
            int secondSell = 0;

            for (int price : prices) {
                firstBuy = Math.max(firstBuy, -price);
                firstSell = Math.max(firstSell, firstBuy + price);
                secondBuy = Math.max(secondBuy, firstSell - price);
                secondSell = Math.max(secondSell, secondBuy + price);
            }

            return secondSell;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
