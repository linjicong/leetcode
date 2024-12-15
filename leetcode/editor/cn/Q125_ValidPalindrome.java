//A phrase is a palindrome if, after converting all uppercase letters into
//lowercase letters and removing all non-alphanumeric characters, it reads the same
//forward and backward. Alphanumeric characters include letters and numbers.
//
// Given a string s, return true if it is a palindrome, or false otherwise.
//
//
// Example 1:
//
//
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
//
//
// Example 2:
//
//
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
//
//
// Example 3:
//
//
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric
//characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 2 * 10⁵
// s consists only of printable ASCII characters.
//
//
// Related Topics 双指针 字符串 👍 785 👎 0

//Valid Palindrome
public class Q125_ValidPalindrome{
    public static void main(String[] args) {
        Solution solution = new Q125_ValidPalindrome().new Solution();
        // 测试用例
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama")); // 输出 true
        System.out.println(solution.isPalindrome("race a car")); // 输出 false
        System.out.println(solution.isPalindrome(" ")); // 输出 true

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean isPalindrome(String s) {
            if (s == null) {
                return false;
            }

            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                // 移动左指针，跳过非字母数字字符
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                }
                // 移动右指针，跳过非字母数字字符
                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                }

                // 比较左右指针指向的字符（忽略大小写）
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }

                // 移动指针
                left++;
                right--;
            }

            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
