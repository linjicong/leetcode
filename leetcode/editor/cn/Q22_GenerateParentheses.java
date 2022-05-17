//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2642 👎 0

import java.util.ArrayList;
import java.util.List;

public class Q22_GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new Q22_GenerateParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            if (n <= 0) {
                return result;
            }
            String str = "";
            generateParenthesis(result, str, 0, 0, n);
            return result;
        }

        private void generateParenthesis(List<String> result, String str, int open, int close, int n) {
            if (str.length() == 2 * n) {
                result.add(str);
                return;
            }
            if (open < n) {
                generateParenthesis(result, str + "(", open + 1, close, n);
            }
            if (close < open) {
                generateParenthesis(result, str + ")", open, close + 1, n);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}