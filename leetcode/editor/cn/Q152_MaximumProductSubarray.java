//Given an integer array nums, find a subarray that has the largest product,
//and return the product.
//
// The test cases are generated so that the answer will fit in a 32-bit integer.
//
//
//
// Example 1:
//
//
//Input: nums = [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
//
//
// Example 2:
//
//
//Input: nums = [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 2 * 10⁴
// -10 <= nums[i] <= 10
// The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
//
//
//
// Related Topics 数组 动态规划 👍 2356 👎 0

//Maximum Product Subarray
public class Q152_MaximumProductSubarray{
    public static void main(String[] args) {
        Solution solution = new Q152_MaximumProductSubarray().new Solution();
        // 测试用例

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int maxProduct = nums[0];
            int minProduct = nums[0];
            int result = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < 0) {
                    // 交换 maxProduct 和 minProduct
                    int temp = maxProduct;
                    maxProduct = minProduct;
                    minProduct = temp;
                }

                // 更新 maxProduct 和 minProduct
                maxProduct = Math.max(nums[i], maxProduct * nums[i]);
                minProduct = Math.min(nums[i], minProduct * nums[i]);

                // 更新结果
                result = Math.max(result, maxProduct);
            }

            return result;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
