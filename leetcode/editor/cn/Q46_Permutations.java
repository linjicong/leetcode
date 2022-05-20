//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
// 示例 2：
//
//
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10
// nums 中的所有整数 互不相同
//
// Related Topics 数组 回溯 👍 2021 👎 0

import java.util.ArrayList;
import java.util.List;

public class Q46_Permutations {
    public static void main(String[] args) {
        Solution solution = new Q46_Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> list;

        public List<List<Integer>> permute(int[] nums) {
            list = new ArrayList<>();//最终的结果
            List<Integer> team = new ArrayList<>();//回溯过程收集元素
            boolean[] jud = new boolean[nums.length];//用来标记
            dfs(jud, nums, team, 0);
            return list;
        }

        public void dfs(boolean[] jud, int[] nums, List<Integer> team, int index) {
            if (index == nums.length) {
                list.add(new ArrayList<>(team));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!jud[i]) {
                    jud[i] = true;
                    team.add(nums[i]);
                    dfs(jud, nums, team, index + 1);
                    team.remove(team.size() - 1);
                    jud[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
