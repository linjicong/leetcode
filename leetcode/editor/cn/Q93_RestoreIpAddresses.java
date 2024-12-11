//A valid IP address consists of exactly four integers separated by single dots.
// Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
//
//
// For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011
//.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
//
//
// Given a string s containing only digits, return all possible valid IP
//addresses that can be formed by inserting dots into s. You are not allowed to reorder
//or remove any digits in s. You may return the valid IP addresses in any order.
//
//
// Example 1:
//
//
//Input: s = "25525511135"
//Output: ["255.255.11.135","255.255.111.35"]
//
//
// Example 2:
//
//
//Input: s = "0000"
//Output: ["0.0.0.0"]
//
//
// Example 3:
//
//
//Input: s = "101023"
//Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 20
// s consists of digits only.
//
//
// Related Topics 字符串 回溯 👍 1466 👎 0

import java.util.ArrayList;
import java.util.List;

//Restore IP Addresses
public class Q93_RestoreIpAddresses{
    public static void main(String[] args) {
        Solution solution = new Q93_RestoreIpAddresses().new Solution();
        // 测试用例
        System.out.println(solution.restoreIpAddresses("25525511135"));
        System.out.println(solution.restoreIpAddresses("0000"));
        System.out.println(solution.restoreIpAddresses("101023"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> ans = new ArrayList<>();
            dfs(s, 0, 0, "", ans);
            return ans;
        }

        private void dfs(String s, int start, int count, String path, List<String> ans) {
            // 如果已经找到4个部分，且遍历完字符串，这是一个有效的IP地址
            if (count == 4 && start == s.length()) {
                ans.add(path.substring(0, path.length() - 1)); // 去掉最后一个点
                return;
            }
            // 如果部分数量不足4个，或者超出字符串长度，直接返回
            if (count > 4 || start > s.length() - 1) return;

            for (int i = 1; i <= 3; i++) {
                // 检查当前部分是否越界
                if (start + i > s.length()) break;
                String part = s.substring(start, start + i);
                // 检查当前部分是否合法
                if (isValid(part)) {
                    dfs(s, start + i, count + 1, path + part + ".", ans);
                }
            }
        }

        // 检查字符串是否为合法的IP地址部分
        private boolean isValid(String s) {
            if (s.length() > 3 || s.length() == 0 || (s.startsWith("0") && s.length() > 1)) {
                return false;
            }
            int num;
            try {
                num = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return false;
            }
            return num >= 0 && num <= 255;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
