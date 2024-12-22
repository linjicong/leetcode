//Given an integer array nums where every element appears three times except
//for one, which appears exactly once. Find the single element and return it.
//
// You must implement a solution with a linear runtime complexity and use only
//constant extra space.
//
//
// Example 1:
// Input: nums = [2,2,3,2]
//Output: 3
//
// Example 2:
// Input: nums = [0,1,0,1,0,1,99]
//Output: 99
//
//
// Constraints:
//
//
// 1 <= nums.length <= 3 * 10⁴
// -2³¹ <= nums[i] <= 2³¹ - 1
// Each element in nums appears exactly three times except for one element
//which appears once.
//
//
// Related Topics 位运算 数组 👍 1268 👎 0

//Single Number II
public class Q137_SingleNumberIi{
    public static void main(String[] args) {
        Solution solution = new Q137_SingleNumberIi().new Solution();
        // 测试用例
        System.out.println(solution.singleNumber(new int[]{2, 2, 3, 2})); // 输出: 3
        System.out.println(solution.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99})); // 输出: 99

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int singleNumber(int[] nums) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                int count = 0;
                for (int num : nums) {
                    // 统计第 i 位上 1 的个数
                    count += (num >> i) & 1;
                }
                // 如果第 i 位上 1 的个数不是 3 的倍数，则结果的第 i 位为 1
                if (count % 3 != 0) {
                    result |= (1 << i);
                }
            }
            return result;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
