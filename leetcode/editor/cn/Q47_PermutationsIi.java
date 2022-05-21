//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//
//
// 示例 2：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
//
// Related Topics 数组 回溯 👍 1068 👎 0
// https://segmentfault.com/a/1190000040142137

import java.util.ArrayList;
import java.util.List;

public class Q47_PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new Q47_PermutationsIi().new Solution();
        solution.permuteUnique(new int[]{1, 1, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return res;
            }
            List<Integer> list = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            dfs(nums, visited, list, res);
            return res;
        }

        private void dfs(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
            if (list.size() == nums.length) {
                for (List<Integer> re : res) {
                    if (re.equals(list)) {
                        return;
                    }
                }
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                    continue;
                }
                visited[i] = true;
                list.add(nums[i]);
                dfs(nums, visited, list, res);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
