//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
//
//
//
//
//
// 示例 1：
//
//
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= n <= 9
//
//
//
// Related Topics 回溯 👍 366 👎 0

import java.util.ArrayList;
import java.util.List;

public class Q52_NQueensIi {
    public static void main(String[] args) {
        Solution solution = new Q52_NQueensIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalNQueens(int n) {
            char[][] chs = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    chs[i][j] = '.';
                }
            }
            List<List<String>> res = new ArrayList<>();
            backTracing(chs, 0, n, res);
            return res.size();
        }

        private void backTracing(char[][] chs, int row, int n, List<List<String>> res) {
            if (row == n) {
                res.add(getRes(chs));
                return;
            }
            for (int i = 0; i < n; i++) {
                if (isValid(chs, row, i)) {
                    chs[row][i] = 'Q';
                    backTracing(chs, row + 1, n, res);
                    chs[row][i] = '.';
                }
            }
        }

        private boolean isValid(char[][] chs, int row, int col) {
            for (int i = 0; i < row; i++) {
                if (chs[i][col] == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (chs[i][j] == 'Q') {
                    return false;
                }
            }
            for (int i = row - 1, j = col + 1; i >= 0 && j < chs.length; i--, j++) {
                if (chs[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }

        private List<String> getRes(char[][] chs) {
            List<String> res = new ArrayList<>();
            for (char[] ch : chs) {
                res.add(new String(ch));
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
