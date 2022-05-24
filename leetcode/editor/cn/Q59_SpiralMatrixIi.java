//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 20
//
// Related Topics 数组 矩阵 模拟 👍 710 👎 0

public class Q59_SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new Q59_SpiralMatrixIi().new Solution();
        int[][] ints = solution.generateMatrix(5);
        System.out.println(ints);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] a = new int[n][n];
            int num = 1;
            int i = 0, j = 0;//行列
            int x = n - 1, y = n - 1;//边界
            int count = 0;
            while (num <= n * n) {
                while (j < (n - count)) {
                    a[i][j++] = num++;
                }
                i++;
                j--;
                while (i < (n - count)) {
                    a[i++][j] = num++;
                }
                i--;
                j--;
                while (j > (count - 1)) {
                    a[i][j--] = num++;
                }
                i--;
                j++;
                while (i > count) {
                    a[i--][j] = num++;
                }
                i++;
                j++;
                count++;
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
