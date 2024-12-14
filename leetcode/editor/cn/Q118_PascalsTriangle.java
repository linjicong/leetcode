//Given an integer numRows, return the first numRows of Pascal's triangle.
//
// In Pascal's triangle, each number is the sum of the two numbers directly
//above it as shown:
//
//
// Example 1:
// Input: numRows = 5
//Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//
// Example 2:
// Input: numRows = 1
//Output: [[1]]
//
//
// Constraints:
//
//
// 1 <= numRows <= 30
//
//
// Related Topics 数组 动态规划 👍 1206 👎 0

import java.util.ArrayList;
import java.util.List;

//Pascal's Triangle
public class Q118_PascalsTriangle{
    public static void main(String[] args) {
        Solution solution = new Q118_PascalsTriangle().new Solution();
        // 测试用例
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> triangle = new ArrayList<>();

            if (numRows <= 0) {
                return triangle;
            }

            // 第一行总是 [1]
            List<Integer> firstRow = new ArrayList<>();
            firstRow.add(1);
            triangle.add(firstRow);

            for (int i = 1; i < numRows; i++) {
                List<Integer> prevRow = triangle.get(i - 1);
                List<Integer> currentRow = new ArrayList<>();

                // 每一行的第一个元素总是 1
                currentRow.add(1);

                // 计算中间的元素
                for (int j = 1; j < i; j++) {
                    int sum = prevRow.get(j - 1) + prevRow.get(j);
                    currentRow.add(sum);
                }

                // 每一行的最后一个元素总是 1
                currentRow.add(1);

                triangle.add(currentRow);
            }

            return triangle;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
