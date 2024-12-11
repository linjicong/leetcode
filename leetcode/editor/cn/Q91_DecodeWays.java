//You have intercepted a secret message encoded as a string of numbers. The
//message is decoded via the following mapping:
//
// "1" -> 'A' "2" -> 'B' ... "25" -> 'Y' "26" -> 'Z'
//
// However, while decoding the message, you realize that there are many
//different ways you can decode the message because some codes are contained in other
//codes ("2" and "5" vs "25").
//
// For example, "11106" can be decoded into:
//
//
// "AAJF" with the grouping (1, 1, 10, 6)
// "KJF" with the grouping (11, 10, 6)
// The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6
//" is valid).
//
//
// Note: there may be strings that are impossible to decode. Given a string s
//containing only digits, return the number of ways to decode it. If the entire
//string cannot be decoded in any valid way, return 0.
//
// The test cases are generated so that the answer fits in a 32-bit integer.
//
//
// Example 1:
//
//
// Input: s = "12"
//
//
// Output: 2
//
// Explanation:
//
// "12" could be decoded as "AB" (1 2) or "L" (12).
//
// Example 2:
//
//
// Input: s = "226"
//
//
// Output: 3
//
// Explanation:
//
// "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
//
// Example 3:
//
//
// Input: s = "06"
//
//
// Output: 0
//
// Explanation:
//
// "06" cannot be mapped to "F" because of the leading zero ("6" is different
//from "06"). In this case, the string is not a valid encoding, so return 0.
//
//
// Constraints:
//
//
// 1 <= s.length <= 100
// s contains only digits and may contain leading zero(s).
//
//
// Related Topics 字符串 动态规划 👍 1572 👎 0

//Decode Ways
public class Q91_DecodeWays{
    public static void main(String[] args) {
        Solution solution = new Q91_DecodeWays().new Solution();
        // 测试用例
        System.out.println(solution.numDecodings("12"));  // 输出: 2
        System.out.println(solution.numDecodings("226")); // 输出: 3
        System.out.println(solution.numDecodings("06"));  // 输出: 0

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // 空字符串有一种解码方式
        dp[1] = 1; // 第一个字符如果不是 '0'，则有一种解码方式

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }

            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
