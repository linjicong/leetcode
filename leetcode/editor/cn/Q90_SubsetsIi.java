//Given an integer array nums that may contain duplicates, return all possible
//subsets (the power set).
//
// The solution set must not contain duplicate subsets. Return the solution in
//any order.
//
//
// Example 1:
// Input: nums = [1,2,2]
//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
//
// Example 2:
// Input: nums = [0]
//Output: [[],[0]]
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
//
//
// Related Topics 位运算 数组 回溯 👍 1252 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Subsets II
public class Q90_SubsetsIi{
    public static void main(String[] args) {
        Solution solution = new Q90_SubsetsIi().new Solution();
        // TO TEST
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2})); // 输出: [[],[1],[1,2],[1,2,2],[2],[2,2]]
        System.out.println(solution.subsetsWithDup(new int[]{0}));       // 输出: [[],[0]]

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums); // 先排序
            backtrack(result, new ArrayList<>(), nums, 0);
            return result;
        }

        private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
            result.add(new ArrayList<>(tempList));
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue; // 跳过重复元素
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
