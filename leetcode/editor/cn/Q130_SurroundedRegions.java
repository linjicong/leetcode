//You are given an m x n matrix board containing letters 'X' and 'O', capture
//regions that are surrounded:
//
//
// Connect: A cell is connected to adjacent cells horizontally or vertically.
// Region: To form a region connect every 'O' cell.
// Surround: The region is surrounded with 'X' cells if you can connect the
//region with 'X' cells and none of the region cells are on the edge of the board.
//
//
// A surrounded region is captured by replacing all 'O's with 'X's in the input
//matrix board.
//
//
// Example 1:
//
//
// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X",
//"O","X","X"]]
//
//
// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X",
//"X"]]
//
// Explanation:
//
// In the above diagram, the bottom region is not captured because it is on the
//edge of the board and cannot be surrounded.
//
// Example 2:
//
//
// Input: board = [["X"]]
//
//
// Output: [["X"]]
//
//
// Constraints:
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] is 'X' or 'O'.
//
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1169 👎 0

//Surrounded Regions
public class Q130_SurroundedRegions{
    public static void main(String[] args) {
        Solution solution = new Q130_SurroundedRegions().new Solution();
        // 测试用例

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public void solve(char[][] board) {
            if (board == null || board.length == 0) {
                return;
            }

            int rows = board.length;
            int cols = board[0].length;

            // 标记边界上的 'O' 和与边界 'O' 连通的 'O'
            for (int i = 0; i < rows; i++) {
                if (board[i][0] == 'O') {
                    dfs(board, i, 0);
                }
                if (board[i][cols - 1] == 'O') {
                    dfs(board, i, cols - 1);
                }
            }

            for (int j = 0; j < cols; j++) {
                if (board[0][j] == 'O') {
                    dfs(board, 0, j);
                }
                if (board[rows - 1][j] == 'O') {
                    dfs(board, rows - 1, j);
                }
            }

            // 替换未标记的 'O' 为 'X'，并将标记的 'O' 恢复为原来的 'O'
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == '#') {
                        board[i][j] = 'O';
                    }
                }
            }
        }

        private void dfs(char[][] board, int i, int j) {
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
                return;
            }

            // 标记当前 'O' 为 '#'
            board[i][j] = '#';

            // 递归标记相邻的 'O'
            dfs(board, i - 1, j);
            dfs(board, i + 1, j);
            dfs(board, i, j - 1);
            dfs(board, i, j + 1);
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
