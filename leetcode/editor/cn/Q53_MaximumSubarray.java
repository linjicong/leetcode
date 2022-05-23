//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 子数组 是数组中的一个连续部分。
//
//
//
// 示例 1：
//
//
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//
// 示例 2：
//
//
//输入：nums = [1]
//输出：1
//
//
// 示例 3：
//
//
//输入：nums = [5,4,-1,7,8]
//输出：23
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// -10⁴ <= nums[i] <= 10⁴
//
//
//
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
// Related Topics 数组 分治 动态规划 👍 4902 👎 0

public class Q53_MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new Q53_MaximumSubarray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int res = nums[0];
            int pre = nums[0];
            int cur = 0;
            for(int i = 1; i < nums.length; i++) {
                //更新cur，相当于更新dp[i]
                cur = nums[i] + Math.max(pre,0);
                //更新最大值
                res = Math.max(res,cur);
                //更新dp[i-1]，使用pre来记录
                pre = cur;
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
