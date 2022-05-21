//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ ）。
//
//
//
// 示例 1：
//
//
//输入：x = 2.00000, n = 10
//输出：1024.00000
//
//
// 示例 2：
//
//
//输入：x = 2.10000, n = 3
//输出：9.26100
//
//
// 示例 3：
//
//
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
//
//
//
//
// 提示：
//
//
// -100.0 < x < 100.0
// -231 <= n <= 231-1
// -104 <= xⁿ <= 104
//
// Related Topics 递归 数学 👍 962 👎 0

public class Q50_PowxN {
    public static void main(String[] args) {
        Solution solution = new Q50_PowxN().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            // 解法1：递归,stackoverflow
            //return n < 0 ? 1 / myPow(x, -n) : n == 0 ? 1 : x * myPow(x, n - 1);

            // 解法2：循环,time limit exceeded
            //double ans = 1;
            //for (int i = 0; i < Math.abs(n); i++) {
            //    ans *= x;
            //}
            //return n < 0 ? 1 / ans : ans;

            if (n == Integer.MIN_VALUE) {
                return (x == 1.0 || x == -1.0) ? 1 : 0;
            }
            if (n == 0) {
                return 1;
            }
            if (n < 0) {
                return myPow(1 / x, -n);
            }
            if (n % 2 == 0) {
                return myPow(x * x, n / 2);
            }
            return x * myPow(x, n - 1);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
