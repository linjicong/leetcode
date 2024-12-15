//A transformation sequence from word beginWord to word endWord using a
//dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
//
//
//
// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need
//to be in wordList.
// sk == endWord
//
//
// Given two words, beginWord and endWord, and a dictionary wordList, return
//the number of words in the shortest transformation sequence from beginWord to
//endWord, or 0 if no such sequence exists.
//
//
// Example 1:
//
//
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
//"lot","log","cog"]
//Output: 5
//Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -
//> "dog" -> cog", which is 5 words long.
//
//
// Example 2:
//
//
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog",
//"lot","log"]
//Output: 0
//Explanation: The endWord "cog" is not in wordList, therefore there is no
//valid transformation sequence.
//
//
//
// Constraints:
//
//
// 1 <= beginWord.length <= 10
// endWord.length == beginWord.length
// 1 <= wordList.length <= 5000
// wordList[i].length == beginWord.length
// beginWord, endWord, and wordList[i] consist of lowercase English letters.
// beginWord != endWord
// All the words in wordList are unique.
//
//
// Related Topics 广度优先搜索 哈希表 字符串 👍 1426 👎 0

import java.util.*;

//Word Ladder
public class Q127_WordLadder{
    public static void main(String[] args) {
        Solution solution = new Q127_WordLadder().new Solution();
        // 测试用例

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            // 将 wordList 转换为 HashSet 以便快速查找
            Set<String> wordSet = new HashSet<>(wordList);

            // 如果 endWord 不在 wordSet 中，直接返回 0
            if (!wordSet.contains(endWord)) {
                return 0;
            }

            // 使用队列进行广度优先搜索
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);

            // 记录访问过的单词
            Set<String> visited = new HashSet<>();
            visited.add(beginWord);

            // 记录当前路径的长度
            int length = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();

                // 遍历当前层的所有节点
                for (int i = 0; i < size; i++) {
                    String currentWord = queue.poll();

                    // 如果当前单词是 endWord，返回当前路径长度
                    if (currentWord.equals(endWord)) {
                        return length;
                    }

                    // 找到所有可以通过改变一个字母得到的单词
                    List<String> neighbors = getNeighbors(currentWord, wordSet);

                    // 将这些邻居加入队列，并标记为已访问
                    for (String neighbor : neighbors) {
                        if (!visited.contains(neighbor)) {
                            queue.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }

                // 当前层遍历完毕，路径长度加 1
                length++;
            }

            // 如果遍历完所有可能的路径仍未找到 endWord，返回 0
            return 0;
        }

        // 获取所有可以通过改变一个字母得到的单词
        private List<String> getNeighbors(String word, Set<String> wordSet) {
            List<String> neighbors = new ArrayList<>();
            char[] chars = word.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                char originalChar = chars[i];

                // 尝试将当前字符替换为其他字符
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == originalChar) {
                        continue;
                    }

                    chars[i] = c;
                    String newWord = new String(chars);

                    // 如果新单词在 wordSet 中，加入邻居列表
                    if (wordSet.contains(newWord)) {
                        neighbors.add(newWord);
                    }
                }

                // 恢复原字符
                chars[i] = originalChar;
            }

            return neighbors;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
