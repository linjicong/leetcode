//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
//
//
// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
//
//
// 给定 n 和 k，返回第 k 个排列。
//
//
//
// 示例 1：
//
//
//输入：n = 3, k = 3
//输出："213"
//
//
// 示例 2：
//
//
//输入：n = 4, k = 9
//输出："2314"
//
//
// 示例 3：
//
//
//输入：n = 3, k = 1
//输出："123"
//
//
//
//
// 提示：
//
//
// 1 <= n <= 9
// 1 <= k <= n!
//
// Related Topics 递归 数学 👍 672 👎 0

import java.util.ArrayList;
import java.util.List;

public class Q60_PermutationSequence {
    public static void main(String[] args) {
        Solution solution = new Q60_PermutationSequence().new Solution();
        String permutation = solution.getPermutation(5, 24);
        System.out.println(permutation);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String getPermutation(int n, int k) {
            //1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880
            int[] factorial = new int[n + 1];
            factorial[0] = 1;
            for (int i = 1; i <= n; i++) {
                factorial[i] = factorial[i - 1] * i;
            }
            StringBuilder sb = new StringBuilder();
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nums.add(i + 1);
            }
            for (int i = n; i > 0; i--) {
                int index = (k - 1) / factorial[i - 1]; //此处不写k/factorial[i-1]是保证当k整除factorial[i-1]时取k/factorial[i-1]-1的值
                sb.append(nums.get(index));
                nums.remove(index);
                k = (k - 1) % factorial[i - 1] + 1;//此处不直接写k%=factorial[i-1]让k-1是保证当k整除factorial[i-1]时得到的不是0而是factorial[i-1]
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
