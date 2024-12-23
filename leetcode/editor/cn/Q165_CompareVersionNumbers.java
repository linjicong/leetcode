//Given two version strings, version1 and version2, compare them. A version
//string consists of revisions separated by dots '.'. The value of the revision is
//its integer conversion ignoring leading zeros.
//
// To compare version strings, compare their revision values in left-to-right
//order. If one of the version strings has fewer revisions, treat the missing
//revision values as 0.
//
// Return the following:
//
//
// If version1 < version2, return -1.
// If version1 > version2, return 1.
// Otherwise, return 0.
//
//
//
// Example 1:
//
//
// Input: version1 = "1.2", version2 = "1.10"
//
//
// Output: -1
//
// Explanation:
//
// version1's second revision is "2" and version2's second revision is "10": 2 <
// 10, so version1 < version2.
//
// Example 2:
//
//
// Input: version1 = "1.01", version2 = "1.001"
//
//
// Output: 0
//
// Explanation:
//
// Ignoring leading zeroes, both "01" and "001" represent the same integer "1".
//
//
// Example 3:
//
//
// Input: version1 = "1.0", version2 = "1.0.0.0"
//
//
// Output: 0
//
// Explanation:
//
// version1 has less revisions, which means every missing revision are treated
//as "0".
//
//
// Constraints:
//
//
// 1 <= version1.length, version2.length <= 500
// version1 and version2 only contain digits and '.'.
// version1 and version2 are valid version numbers.
// All the given revisions in version1 and version2 can be stored in a 32-bit
//integer.
//
//
// Related Topics 双指针 字符串 👍 436 👎 0

//Compare Version Numbers
public class Q165_CompareVersionNumbers{
    public static void main(String[] args) {
        Solution solution = new Q165_CompareVersionNumbers().new Solution();
        // 测试用例

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int compareVersion(String version1, String version2) {
            // 分割版本字符串
            String[] v1Parts = version1.split("\\.");
            String[] v2Parts = version2.split("\\.");

            // 获取两个版本字符串的修订号数量
            int length1 = v1Parts.length;
            int length2 = v2Parts.length;

            // 逐个比较修订号
            for (int i = 0; i < Math.max(length1, length2); i++) {
                int v1 = i < length1 ? Integer.parseInt(v1Parts[i]) : 0;
                int v2 = i < length2 ? Integer.parseInt(v2Parts[i]) : 0;

                if (v1 < v2) {
                    return -1;
                } else if (v1 > v2) {
                    return 1;
                }
            }

            // 所有修订号都相等
            return 0;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
