//Given an integer columnNumber, return its corresponding column title as it
//appears in an Excel sheet.
//
// For example:
//
//
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28
//...
//
//
//
// Example 1:
//
//
//Input: columnNumber = 1
//Output: "A"
//
//
// Example 2:
//
//
//Input: columnNumber = 28
//Output: "AB"
//
//
// Example 3:
//
//
//Input: columnNumber = 701
//Output: "ZY"
//
//
//
// Constraints:
//
//
// 1 <= columnNumber <= 2³¹ - 1
//
//
// Related Topics 数学 字符串 👍 709 👎 0

//Excel Sheet Column Title
public class Q168_ExcelSheetColumnTitle{
    public static void main(String[] args) {
        Solution solution = new Q168_ExcelSheetColumnTitle().new Solution();
        // 测试用例

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder result = new StringBuilder();

            while (columnNumber > 0) {
                columnNumber--; // 将 columnNumber 转换为从 0 开始的系统
                int remainder = columnNumber % 26;
                char letter = (char) ('A' + remainder);
                result.append(letter);
                columnNumber /= 26;
            }

            return result.reverse().toString();
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
