//给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
//
//
//
// 示例 1：
//
//
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
//
//
// 示例 2：
//
//
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
//
//
// 示例 3：
//
//
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁴
// s 由小写英文字母组成
// 1 <= words.length <= 5000
// 1 <= words[i].length <= 30
// words[i] 由小写英文字母组成
//
// Related Topics 哈希表 字符串 滑动窗口 👍 658 👎 0

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Q30_SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new Q30_SubstringWithConcatenationOfAllWords().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> result = new LinkedList<>();
            int length = s.length();
            //单词长度
            int wordLength = words[0].length();
            //words中单词的个数
            int wordsCount = words.length;
            //words里单词的总长度
            int wordsTotal = wordLength * wordsCount;
            if (wordsTotal > length) {
                return result;
            }
            //将words中单词放入map1中
            HashMap<String, Integer> map1 = new HashMap();
            for (String str : words) {
                int count = map1.getOrDefault(str, 0);
                map1.put(str, count + 1);
            }
            //遍历字符串s
            for (int start = 0; start <= length - wordsTotal; start++) {
                HashMap<String, Integer> map2 = new HashMap();
                //用于计算，符合条件字符串的个数
                int count = 0;
                while (true) {
                    //截取start指针到end指针的字符串，end=start+wordLength*count + wordLength
                    String str = s.substring(start + wordLength * count, start + wordLength * count + wordLength);
                    if (!map1.containsKey(str)) {
                        break;
                    }
                    int i = map1.get(str);
                    int j = map2.getOrDefault(str, 0);
                    if (j + 1 > i) {
                        break;
                    }
                    map2.put(str, j + 1);
                    count++;
                    //将count等于words单词的个数，说明符合条条件，将初始下标加入结果集
                    if (count == wordsCount) {
                        result.add(start);
                        break;
                    }
                }
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
