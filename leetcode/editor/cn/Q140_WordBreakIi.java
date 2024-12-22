//Given a string s and a dictionary of strings wordDict, add spaces in s to
//construct a sentence where each word is a valid dictionary word. Return all such
//possible sentences in any order.
//
// Note that the same word in the dictionary may be reused multiple times in
//the segmentation.
//
//
// Example 1:
//
//
//Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
//Output: ["cats and dog","cat sand dog"]
//
//
// Example 2:
//
//
//Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine",
//"pineapple"]
//Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
//Explanation: Note that you are allowed to reuse a dictionary word.
//
//
// Example 3:
//
//
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: []
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 20
// 1 <= wordDict.length <= 1000
// 1 <= wordDict[i].length <= 10
// s and wordDict[i] consist of only lowercase English letters.
// All the strings of wordDict are unique.
// Input is generated in a way that the length of the answer doesn't exceed 10⁵.
//
//
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 回溯 👍 770 👎 0

import java.util.*;

//Word Break II
public class Q140_WordBreakIi{
    public static void main(String[] args) {
        Solution solution = new Q140_WordBreakIi().new Solution();
        // 测试用例
        System.out.println(solution.wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog")));
        // 输出: ["cats and dog", "cat sand dog"]
        System.out.println(solution.wordBreak("pineapplepenapple", List.of("apple", "pen", "applepen", "pine", "pineapple")));
        // 输出: ["pine apple pen apple", "pineapple pen apple", "pine applepen apple"]
        System.out.println(solution.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
        // 输出: []
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private Map<Integer, List<String>> memo;
        private Set<String> wordSet;

        public List<String> wordBreak(String s, List<String> wordDict) {
            memo = new HashMap<>();
            wordSet = new HashSet<>(wordDict);
            return backtrack(s, 0);
        }

        private List<String> backtrack(String s, int start) {
            if (memo.containsKey(start)) {
                return memo.get(start);
            }

            List<String> sentences = new ArrayList<>();
            if (start == s.length()) {
                sentences.add("");
                return sentences;
            }

            for (int end = start + 1; end <= s.length(); end++) {
                String word = s.substring(start, end);
                if (wordSet.contains(word)) {
                    List<String> subSentences = backtrack(s, end);
                    for (String subSentence : subSentences) {
                        if (subSentence.isEmpty()) {
                            sentences.add(word);
                        } else {
                            sentences.add(word + " " + subSentence);
                        }
                    }
                }
            }

            memo.put(start, sentences);
            return sentences;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
