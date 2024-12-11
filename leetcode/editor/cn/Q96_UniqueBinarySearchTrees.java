//Given an integer n, return the number of structurally unique BST's (binary
//search trees) which has exactly n nodes of unique values from 1 to n.
//
//
// Example 1:
//
//
//Input: n = 3
//Output: 5
//
//
// Example 2:
//
//
//Input: n = 1
//Output: 1
//
//
//
// Constraints:
//
//
// 1 <= n <= 19
//
//
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 2585 👎 0

//Unique Binary Search Trees
public class Q96_UniqueBinarySearchTrees{
    public static void main(String[] args) {
        Solution solution = new Q96_UniqueBinarySearchTrees().new Solution();
        // 测试用例
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int numTrees(int n) {
            if (n <= 1) {
                return 1;
            }

            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }

            return dp[n];
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
