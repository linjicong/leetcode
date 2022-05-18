//编写一个程序，通过填充空格来解决数独问题。
//
// 数独的解法需 遵循如下规则：
//
//
// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
//
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".
//",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".
//","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6
//"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[
//".",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8
//"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],[
//"4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9",
//"6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4",
//"5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
//
//
//
//
//
//
// 提示：
//
//
// board.length == 9
// board[i].length == 9
// board[i][j] 是一位数字或者 '.'
// 题目数据 保证 输入数独仅有一个解
//
//
//
//
// Related Topics 数组 回溯 矩阵 👍 1267 👎 0

public class Q37_SudokuSolver {
    public static void main(String[] args) {
        Solution solution = new Q37_SudokuSolver().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private boolean[][] digit;
        private char[][] result;
        private boolean[][] row;
        private boolean[][] col;
        private boolean[][] block;
        private boolean end;

        public void solveSudoku(char[][] board) {
// 回溯算法
            // 初始化
            this.digit = new boolean[9][9];
            this.result = board;
            this.row = new boolean[9][10];
            this.col = new boolean[9][10];
            this.block = new boolean[9][10];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        int temp = (int) (board[i][j] - '0');
                        row[i][temp] = true;
                        col[j][temp] = true;
                        block[3 * (i / 3) + j / 3][temp] = true;
                        digit[i][j] = true;
                    }
                }
            }
            DFS(0, 0); // 从第一行第一列开始
        }

        public void DFS(int x, int y) {
            if (x < 8 && y == 9) {
                DFS(x + 1, 0);
                return;
            }
            if (x == 8 && y == 9) {
                end = true;
                return;
            }
            for (int i = 1; i <= 9 && !end; i++) { // 遍历当前位置需要填入的值 这里有坑：一定注意end标记要放再这里！否则会被覆盖修改！
                if (!digit[x][y]) { // 当前位置不为固定数字
                    if (check(x, y, i)) { // 判断当前位置是否符合规则
                        row[x][i] = true;
                        col[y][i] = true;
                        block[3 * (x / 3) + y / 3][i] = true;
                        result[x][y] = (char) (i + '0');
                        DFS(x, y + 1); // 对下一列空格位置递归
                        row[x][i] = false;
                        col[y][i] = false;
                        block[3 * (x / 3) + y / 3][i] = false;
                    }
                } else { // 当前位置为固定数字
                    DFS(x, y + 1);
                    return;
                }
            }
        }
        public boolean check(int r,int c,int n){
            if(row[r][n] || col[c][n] || block[3*(r/3)+c/3][n]){ // 行判断、列判断和块判断
                return false;
            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
