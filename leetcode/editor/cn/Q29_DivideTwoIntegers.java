//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
//
// 返回被除数 dividend 除以除数 divisor 得到的商。
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
//
//
//
// 示例 1:
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
//
// 示例 2:
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2
//
//
//
// 提示：
//
//
// 被除数和除数均为 32 位有符号整数。
// 除数不为 0。
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2³¹, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
//
// Related Topics 位运算 数学 👍 901 👎 0

public class Q29_DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new Q29_DivideTwoIntegers().new Solution();
        int result = solution.divide(-2147483648, -2147483648);
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
            if (dividend == 0) return 0;
            if (divisor == 1) return dividend;
            if (divisor == -1) return -dividend;
            //if (divisor == Integer.MIN_VALUE) return 0;
            boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
            int res = 0;
            long ldividend = Math.abs((long) dividend);
            long ldivisor = Math.abs((long) divisor);
            while (ldividend >= ldivisor) {
                long temp = ldivisor;
                int count = 1;
                while (ldividend >= (temp << 1)) {
                    temp <<= 1;
                    count <<= 1;
                }
                ldividend -= temp;
                res += count;
            }
            return isNegative ? -res : res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
