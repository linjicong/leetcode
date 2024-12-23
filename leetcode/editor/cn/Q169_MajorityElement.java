//Given an array nums of size n, return the majority element.
//
// The majority element is the element that appears more than ⌊n / 2⌋ times.
//You may assume that the majority element always exists in the array.
//
//
// Example 1:
// Input: nums = [3,2,3]
//Output: 3
//
// Example 2:
// Input: nums = [2,2,1,1,1,2,2]
//Output: 2
//
//
// Constraints:
//
//
// n == nums.length
// 1 <= n <= 5 * 10⁴
// -10⁹ <= nums[i] <= 10⁹
//
//
//
//Follow-up: Could you solve the problem in linear time and in
//O(1) space?
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 2351 👎 0

//Majority Element
public class Q169_MajorityElement{
    public static void main(String[] args) {
        Solution solution = new Q169_MajorityElement().new Solution();
        // 测试用例

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int majorityElement(int[] nums) {
            int candidate = 0;
            int count = 0;

            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += (num == candidate) ? 1 : -1;
            }

            return candidate;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
