//An n-bit gray code sequence is a sequence of 2ⁿ integers where:
//
//
// Every integer is in the inclusive range [0, 2ⁿ - 1],
// The first integer is 0,
// An integer appears no more than once in the sequence,
// The binary representation of every pair of adjacent integers differs by
//exactly one bit, and
// The binary representation of the first and last integers differs by exactly
//one bit.
//
//
// Given an integer n, return any valid n-bit gray code sequence.
//
//
// Example 1:
//
//
//Input: n = 2
//Output: [0,1,3,2]
//Explanation:
//The binary representation of [0,1,3,2] is [00,01,11,10].
//- 00 and 01 differ by one bit
//- 01 and 11 differ by one bit
//- 11 and 10 differ by one bit
//- 10 and 00 differ by one bit
//[0,2,3,1] is also a valid gray code sequence, whose binary representation is [
//00,10,11,01].
//- 00 and 10 differ by one bit
//- 10 and 11 differ by one bit
//- 11 and 01 differ by one bit
//- 01 and 00 differ by one bit
//
//
// Example 2:
//
//
//Input: n = 1
//Output: [0,1]
//
//
//
// Constraints:
//
//
// 1 <= n <= 16
//
//
// Related Topics 位运算 数学 回溯 👍 692 👎 0

import java.util.ArrayList;
import java.util.List;

//Gray Code
public class Q89_GrayCode{
    public static void main(String[] args) {
        Solution solution = new Q89_GrayCode().new Solution();
        // TO TEST
        System.out.println(solution.grayCode(0)); // 输出: [0]
        System.out.println(solution.grayCode(1)); // 输出: [0, 1]
        System.out.println(solution.grayCode(2)); // 输出: [0, 1, 3, 2]
        System.out.println(solution.grayCode(3)); // 输出: [0, 1, 3, 2, 6, 7, 5, 4]

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0); // n = 0 时的 Gray 码

        for (int i = 0; i < n; i++) {
            int size = result.size();
            for (int j = size - 1; j >= 0; j--) {
                result.add(result.get(j) | (1 << i));
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
