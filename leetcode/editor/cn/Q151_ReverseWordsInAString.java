//Given an input string s, reverse the order of the words.
//
// A word is defined as a sequence of non-space characters. The words in s will
//be separated by at least one space.
//
// Return a string of the words in reverse order concatenated by a single space.
//
//
// Note that s may contain leading or trailing spaces or multiple spaces
//between two words. The returned string should only have a single space separating the
//words. Do not include any extra spaces.
//
//
// Example 1:
//
//
//Input: s = "the sky is blue"
//Output: "blue is sky the"
//
//
// Example 2:
//
//
//Input: s = "  hello world  "
//Output: "world hello"
//Explanation: Your reversed string should not contain leading or trailing
//spaces.
//
//
// Example 3:
//
//
//Input: s = "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single
//space in the reversed string.
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 10⁴
// s contains English letters (upper-case and lower-case), digits, and spaces '
//'.
// There is at least one word in s.
//
//
//
// Follow-up: If the string data type is mutable in your language, can you
//solve it in-place with O(1) extra space?
//
// Related Topics 双指针 字符串 👍 1242 👎 0

//Reverse Words in a String
public class Q151_ReverseWordsInAString{
    public static void main(String[] args) {
        Solution solution = new Q151_ReverseWordsInAString().new Solution();
        // 测试用例

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String reverseWords(String s) {
            // 去除开头和结尾的空格，并将多个连续空格替换为单个空格
            s = s.trim().replaceAll("\\s+", " ");
            // 分割字符串为单词数组
            String[] words = s.split(" ");
            // 反转单词数组
            StringBuilder result = new StringBuilder();
            for (int i = words.length - 1; i >= 0; i--) {
                result.append(words[i]);
                if (i != 0) {
                    result.append(" ");
                }
            }
            return result.toString();
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
