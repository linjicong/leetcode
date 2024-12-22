//Given a string s, partition s such that every substring of the partition is a
//palindrome.
//
// Return the minimum cuts needed for a palindrome partitioning of s.
//
//
// Example 1:
//
//
//Input: s = "aab"
//Output: 1
//Explanation: The palindrome partitioning ["aa","b"] could be produced using 1
//cut.
//
//
// Example 2:
//
//
//Input: s = "a"
//Output: 0
//
//
// Example 3:
//
//
//Input: s = "ab"
//Output: 1
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 2000
// s consists of lowercase English letters only.
//
//
// Related Topics 字符串 动态规划 👍 775 👎 0

//Palindrome Partitioning II
public class Q132_PalindromePartitioningIi{
    public static void main(String[] args) {
        Solution solution = new Q132_PalindromePartitioningIi().new Solution();
        // 测试用例
        System.out.println(solution.minCut("aab")); // 输出: 1
        System.out.println(solution.minCut("a"));   // 输出: 0
        System.out.println(solution.minCut("ab"));  // 输出: 1

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int minCut(String s) {
            int n = s.length();
            if (n <= 1) return 0;

            // dp[i][j] 表示子串 s[i...j] 是否为回文
            boolean[][] dp = new boolean[n][n];
            // cuts[i] 表示 s[0...i] 的最小切割次数
            int[] cuts = new int[n];

            for (int i = 0; i < n; i++) {
                int minCuts = i; // 最坏情况下，每个字符单独分割
                for (int j = 0; j <= i; j++) {
                    if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || dp[j + 1][i - 1])) {
                        dp[j][i] = true;
                        if (j == 0) {
                            minCuts = 0; // 如果 s[0...i] 是回文，不需要切割
                        } else {
                            minCuts = Math.min(minCuts, cuts[j - 1] + 1);
                        }
                    }
                }
                cuts[i] = minCuts;
            }

            return cuts[n - 1];
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
