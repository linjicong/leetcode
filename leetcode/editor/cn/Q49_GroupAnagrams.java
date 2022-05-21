//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
//
//
//
// 示例 1:
//
//
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
// 示例 2:
//
//
//输入: strs = [""]
//输出: [[""]]
//
//
// 示例 3:
//
//
//输入: strs = ["a"]
//输出: [["a"]]
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 10⁴
// 0 <= strs[i].length <= 100
// strs[i] 仅包含小写字母
//
// Related Topics 哈希表 字符串 排序 👍 1142 👎 0

import java.util.*;

public class Q49_GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new Q49_GroupAnagrams().new Solution();
        List<List<String>> lists = solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> hash = new HashMap<>();
            //map:key:排序后的字符串，value:没排序的字符串组成的列表（具有相同的字母）
            for (int i = 0; i < strs.length; i++) {
                char[] tempc = strs[i].toCharArray();
                tempc = strs[i].toCharArray();
                Arrays.sort(tempc);
                String ts = new String(tempc);
                if (!hash.containsKey(ts)) {
                    hash.put(ts, new LinkedList<>());
                }
                hash.get(ts).add(strs[i]);
            }
            //存入列表
            LinkedList list = new LinkedList();
            for (String s : hash.keySet()) {
                list.add(hash.get(s));
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
