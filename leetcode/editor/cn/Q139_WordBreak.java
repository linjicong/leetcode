//Given a string s and a dictionary of strings wordDict, return true if s can
//be segmented into a space-separated sequence of one or more dictionary words.
//
// Note that the same word in the dictionary may be reused multiple times in
//the segmentation.
//
//
// Example 1:
//
//
//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
//
//
// Example 2:
//
//
//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple
//pen apple".
//Note that you are allowed to reuse a dictionary word.
//
//
// Example 3:
//
//
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: false
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 300
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 20
// s and wordDict[i] consist of only lowercase English letters.
// All the strings of wordDict are unique.
//
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 👍 2634 👎 0

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Word Break
public class Q139_WordBreak{
    public static void main(String[] args) {
        Solution solution = new Q139_WordBreak().new Solution();
        // 测试用例
        System.out.println(solution.wordBreak("leetcode", List.of("leet", "code"))); // 输出: true
        System.out.println(solution.wordBreak("applepenapple", List.of("apple", "pen"))); // 输出: true
        System.out.println(solution.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))); // 输出: false

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordSet = new HashSet<>(wordDict);
            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[n];
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
