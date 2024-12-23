//Given an integer array nums, return the maximum difference between two
//successive elements in its sorted form. If the array contains less than two elements,
//return 0.
//
// You must write an algorithm that runs in linear time and uses linear extra
//space.
//
//
// Example 1:
//
//
//Input: nums = [3,6,9,1]
//Output: 3
//Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9)
//has the maximum difference 3.
//
//
// Example 2:
//
//
//Input: nums = [10]
//Output: 0
//Explanation: The array contains less than 2 elements, therefore return 0.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10⁵
// 0 <= nums[i] <= 10⁹
//
//
// Related Topics 数组 桶排序 基数排序 排序 👍 637 👎 0

//Maximum Gap
public class Q164_MaximumGap{
    public static void main(String[] args) {
        Solution solution = new Q164_MaximumGap().new Solution();
        // 测试用例

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int maximumGap(int[] nums) {
            if (nums == null || nums.length < 2) {
                return 0;
            }

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            // 找到数组中的最小值和最大值
            for (int num : nums) {
                if (num < min) {
                    min = num;
                }
                if (num > max) {
                    max = num;
                }
            }

            // 如果所有元素相同，最大间隔为 0
            if (min == max) {
                return 0;
            }

            // 计算桶的大小和数量
            int n = nums.length;
            int bucketSize = Math.max(1, (max - min) / (n - 1));
            int bucketCount = (max - min) / bucketSize + 1;

            // 创建桶数组
            int[][] buckets = new int[bucketCount][2];
            for (int[] bucket : buckets) {
                bucket[0] = Integer.MAX_VALUE; // 桶的最小值
                bucket[1] = Integer.MIN_VALUE; // 桶的最大值
            }

            // 将元素分配到桶中
            for (int num : nums) {
                int idx = (num - min) / bucketSize;
                buckets[idx][0] = Math.min(buckets[idx][0], num);
                buckets[idx][1] = Math.max(buckets[idx][1], num);
            }

            // 计算最大间隔
            int maxGap = 0;
            int prevMax = min;
            for (int[] bucket : buckets) {
                if (bucket[0] == Integer.MAX_VALUE) {
                    continue; // 跳过空桶
                }
                maxGap = Math.max(maxGap, bucket[0] - prevMax);
                prevMax = bucket[1];
            }

            return maxGap;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
