//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
// 示例 1:
//
//
//
//
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
//
//
// 示例 2：
//
//
//
//
//输入： heights = [2,4]
//输出： 4
//
//
//
// 提示：
//
//
// 1 <= heights.length <=10⁵
// 0 <= heights[i] <= 10⁴
//
// Related Topics 栈 数组 单调栈 👍 1973 👎 0

import java.util.Stack;

public class Q84_LargestRectangleInHistogram{
  public static void main(String[] args) {
       Solution solution = new Q84_LargestRectangleInHistogram().new Solution();
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int index = stack.pop();
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, w * heights[index]);
            }
            stack.push(i);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
