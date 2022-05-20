//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,0]
//输出：3
//
//
// 示例 2：
//
//
//输入：nums = [3,4,-1,1]
//输出：2
//
//
// 示例 3：
//
//
//输入：nums = [7,8,9,11,12]
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5 * 10⁵
// -2³¹ <= nums[i] <= 2³¹ - 1
//
// Related Topics 数组 哈希表 👍 1476 👎 0

public class Q41_FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new Q41_FirstMissingPositive().new Solution();
        solution.firstMissingPositive(new int[]{1, 12, 0, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int len = nums.length;
            int[] arr = new int[len + 1];
            // 在arr数组对应的位置上如果出现了则设置数字1
            for (int i = 0; i < len; i++) {
                if (nums[i] > 0 && nums[i] <= len) {
                    arr[nums[i]] = 1;
                }
            }
            // 找到第一个没有出现的数字(第1个0)
            for (int i = 1; i <= len; i++) {
                if (arr[i] == 0) {
                    return i;
                }
            }
            return len + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
