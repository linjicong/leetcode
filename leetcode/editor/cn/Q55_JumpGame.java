//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 判断你是否能够到达最后一个下标。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 10⁴
// 0 <= nums[i] <= 10⁵
//
// Related Topics 贪心 数组 动态规划 👍 1848 👎 0

public class Q55_JumpGame {
    public static void main(String[] args) {
        Solution solution = new Q55_JumpGame().new Solution();
        solution.canJump(new int[]{2, 3, 1, 1, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            if (nums.length <= 1) return true;
            int end = 0;   //保存能够到达的最远位置
            for (int i = 0; i < nums.length - 1; i++) {
                end = Math.max(end, i + nums[i]);
                if (end >= nums.length - 1) return true; //如果已经>=最后一个位置，直接返回true
                if (i == end && nums[end] == 0) break; //说明不可能到达最后一个位置
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
