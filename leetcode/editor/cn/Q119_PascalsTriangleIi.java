//Given an integer rowIndex, return the rowIndexᵗʰ (0-indexed) row of the
//Pascal's triangle.
//
// In Pascal's triangle, each number is the sum of the two numbers directly
//above it as shown:
//
//
// Example 1:
// Input: rowIndex = 3
//Output: [1,3,3,1]
//
// Example 2:
// Input: rowIndex = 0
//Output: [1]
//
// Example 3:
// Input: rowIndex = 1
//Output: [1,1]
//
//
// Constraints:
//
//
// 0 <= rowIndex <= 33
//
//
//
// Follow up: Could you optimize your algorithm to use only O(rowIndex) extra
//space?
//
// Related Topics 数组 动态规划 👍 558 👎 0

import java.util.ArrayList;
import java.util.List;

//Pascal's Triangle II
public class Q119_PascalsTriangleIi{
    public static void main(String[] args) {
        Solution solution = new Q119_PascalsTriangleIi().new Solution();
        // 测试用例
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> row = new ArrayList<>(rowIndex + 1);

            // 初始化第一行
            for (int i = 0; i <= rowIndex; i++) {
                row.add(1);
            }

            // 逐行计算
            for (int i = 1; i <= rowIndex; i++) {
                // 从后向前更新当前行的值
                for (int j = i - 1; j > 0; j--) {
                    row.set(j, row.get(j) + row.get(j - 1));
                }
            }

            return row;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
