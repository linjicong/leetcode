//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
//
//
//
// 示例 1：
//
//
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
//
//
// 示例 2：
//
//
//输入：matrix = []
//输出：0
//
//
// 示例 3：
//
//
//输入：matrix = [["0"]]
//输出：0
//
//
// 示例 4：
//
//
//输入：matrix = [["1"]]
//输出：1
//
//
// 示例 5：
//
//
//输入：matrix = [["0","0"]]
//输出：0
//
//
//
//
// 提示：
//
//
// rows == matrix.length
// cols == matrix[0].length
// 1 <= row, cols <= 200
// matrix[i][j] 为 '0' 或 '1'
//
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1285 👎 0

public class Q85_MaximalRectangle{
  public static void main(String[] args) {
       Solution solution = new Q85_MaximalRectangle().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                    int min = dp[i][j];
                    for (int k = i; k >= 0; k--) {
                        min = Math.min(min, dp[k][j]);
                        max = Math.max(max, min * (i - k + 1));
                    }
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
