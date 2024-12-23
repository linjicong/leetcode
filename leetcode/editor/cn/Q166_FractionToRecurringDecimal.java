//Given two integers representing the numerator and denominator of a fraction,
//return the fraction in string format.
//
// If the fractional part is repeating, enclose the repeating part in
//parentheses.
//
// If multiple answers are possible, return any of them.
//
// It is guaranteed that the length of the answer string is less than 10⁴ for
//all the given inputs.
//
//
// Example 1:
//
//
//Input: numerator = 1, denominator = 2
//Output: "0.5"
//
//
// Example 2:
//
//
//Input: numerator = 2, denominator = 1
//Output: "2"
//
//
// Example 3:
//
//
//Input: numerator = 4, denominator = 333
//Output: "0.(012)"
//
//
//
// Constraints:
//
//
// -2³¹ <= numerator, denominator <= 2³¹ - 1
// denominator != 0
//
//
// Related Topics 哈希表 数学 字符串 👍 503 👎 0

import java.util.HashMap;
import java.util.Map;

//Fraction to Recurring Decimal
public class Q166_FractionToRecurringDecimal{
    public static void main(String[] args) {
        Solution solution = new Q166_FractionToRecurringDecimal().new Solution();
        // 测试用例

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String fractionToDecimal(int numerator, int denominator) {
            if (numerator == 0) {
                return "0";
            }

            StringBuilder result = new StringBuilder();
            // 处理符号
            if ((numerator < 0) ^ (denominator < 0)) {
                result.append("-");
            }

            // 使用 long 避免溢出
            long num = Math.abs((long) numerator);
            long den = Math.abs((long) denominator);

            // 处理整数部分
            result.append(num / den);
            num %= den;
            if (num == 0) {
                return result.toString();
            }

            // 处理小数部分
            result.append(".");
            Map<Long, Integer> remainderIndexMap = new HashMap<>();
            while (num != 0) {
                if (remainderIndexMap.containsKey(num)) {
                    // 检测到循环
                    int index = remainderIndexMap.get(num);
                    result.insert(index, "(");
                    result.append(")");
                    break;
                }
                remainderIndexMap.put(num, result.length());
                num *= 10;
                result.append(num / den);
                num %= den;
            }

            return result.toString();
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
