//Given a string s, partition s such that every substring of the partition is a
//palindrome. Return all possible palindrome partitioning of s.
//
//
// Example 1:
// Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
//
// Example 2:
// Input: s = "a"
//Output: [["a"]]
//
//
// Constraints:
//
//
// 1 <= s.length <= 16
// s contains only lowercase English letters.
//
//
// Related Topics 字符串 动态规划 回溯 👍 1906 👎 0

import java.util.ArrayList;
import java.util.List;

//Palindrome Partitioning
public class Q131_PalindromePartitioning{
    public static void main(String[] args) {
        Solution solution = new Q131_PalindromePartitioning().new Solution();
        // 测试用例

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();
            backtrack(s, 0, new ArrayList<>(), result);
            return result;
        }

        private void backtrack(String s, int start, List<String> temp, List<List<String>> result) {
            if (start == s.length()) {
                result.add(new ArrayList<>(temp));
                return;
            }

            for (int end = start; end < s.length(); end++) {
                if (isPalindrome(s, start, end)) {
                    temp.add(s.substring(start, end + 1));
                    backtrack(s, end + 1, temp, result);
                    temp.remove(temp.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
