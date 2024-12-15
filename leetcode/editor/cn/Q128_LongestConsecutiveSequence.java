//Given an unsorted array of integers nums, return the length of the longest
//consecutive elements sequence.
//
// You must write an algorithm that runs in O(n) time.
//
//
// Example 1:
//
//
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
//Therefore its length is 4.
//
//
// Example 2:
//
//
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
//
//
//
// Constraints:
//
//
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
//
//
// Related Topics 并查集 数组 哈希表 👍 2299 👎 0

import java.util.HashSet;
import java.util.Set;

//Longest Consecutive Sequence
public class Q128_LongestConsecutiveSequence{
    public static void main(String[] args) {
        Solution solution = new Q128_LongestConsecutiveSequence().new Solution();
        // 测试用例

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            Set<Integer> numSet = new HashSet<>();
            for (int num : nums) {
                numSet.add(num);
            }

            int longestStreak = 0;

            for (int num : numSet) {
                // 只有当 num 是一个序列的起点时才开始计数
                if (!numSet.contains(num - 1)) {
                    int currentNum = num;
                    int currentStreak = 1;

                    // 计算序列的长度
                    while (numSet.contains(currentNum + 1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }

                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }

            return longestStreak;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
