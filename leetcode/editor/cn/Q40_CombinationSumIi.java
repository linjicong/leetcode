//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用 一次 。
//
// 注意：解集不能包含重复的组合。
//
//
//
// 示例 1:
//
//
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//
// 示例 2:
//
//
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//]
//
//
//
// 提示:
//
//
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30
//
// Related Topics 数组 回溯 👍 970 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40_CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new Q40_CombinationSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            backtrack(result, new ArrayList<>(), candidates, target, 0);
            return result;
        }
        private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int remain, int start) {
            if (remain < 0) {
                return;
            }
            if (remain == 0) {
                result.add(new ArrayList<>(tempList));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
