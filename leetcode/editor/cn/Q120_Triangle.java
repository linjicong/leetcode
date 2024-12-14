//Given a triangle array, return the minimum path sum from top to bottom.
//
// For each step, you may move to an adjacent number of the row below. More
//formally, if you are on index i on the current row, you may move to either index i
//or index i + 1 on the next row.
//
//
// Example 1:
//
//
//Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//Output: 11
//Explanation: The triangle looks like:
//   2
//  3 4
// 6 5 7
//4 1 8 3
//The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined
//above).
//
//
// Example 2:
//
//
//Input: triangle = [[-10]]
//Output: -10
//
//
//
// Constraints:
//
//
// 1 <= triangle.length <= 200
// triangle[0].length == 1
// triangle[i].length == triangle[i - 1].length + 1
// -10⁴ <= triangle[i][j] <= 10⁴
//
//
//
//Follow up: Could you do this using only
//O(n) extra space, where
//n is the total number of rows in the triangle?
//
// Related Topics 数组 动态规划 👍 1395 👎 0

import java.util.List;

//Triangle
public class Q120_Triangle{
    public static void main(String[] args) {
        Solution solution = new Q120_Triangle().new Solution();
        // 测试用例
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] dp = new int[n];

            // 初始化最后一行
            for (int i = 0; i < n; i++) {
                dp[i] = triangle.get(n - 1).get(i);
            }

            // 从倒数第二行开始向上计算
            for (int i = n - 2; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
                }
            }

            // 最终结果保存在 dp[0]
            return dp[0];
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
