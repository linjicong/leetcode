//Given two strings s and t, return the number of distinct subsequences of s
//which equals t.
//
// The test cases are generated so that the answer fits on a 32-bit signed
//integer.
//
//
// Example 1:
//
//
//Input: s = "rabbbit", t = "rabbit"
//Output: 3
//Explanation:
//As shown below, there are 3 ways you can generate "rabbit" from s.
//rabbbit
//rabbbit
//rabbbit
//
//
// Example 2:
//
//
//Input: s = "babgbag", t = "bag"
//Output: 5
//Explanation:
//As shown below, there are 5 ways you can generate "bag" from s.
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag
//
//
// Constraints:
//
//
// 1 <= s.length, t.length <= 1000
// s and t consist of English letters.
//
//
// Related Topics 字符串 动态规划 👍 1295 👎 0

//Distinct Subsequences
public class Q115_DistinctSubsequences{
    public static void main(String[] args) {
        Solution solution = new Q115_DistinctSubsequences().new Solution();
        // 测试用例
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int numDistinct(String s, String t) {
            int m = s.length();
            int n = t.length();

            // dp[i][j] 表示 s 的前 i 个字符中作为子序列出现的 t 的前 j 个字符的不同数量
            int[][] dp = new int[m + 1][n + 1];

            // 初始化 dp[i][0] = 1，因为空字符串 t 是任何字符串 s 的子序列
            for (int i = 0; i <= m; i++) {
                dp[i][0] = 1;
            }

            // 填充 dp 数组
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            return dp[m][n];
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
