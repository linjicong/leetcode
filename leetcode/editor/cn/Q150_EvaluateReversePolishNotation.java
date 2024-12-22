//You are given an array of strings tokens that represents an arithmetic
//expression in a Reverse Polish Notation.
//
// Evaluate the expression. Return an integer that represents the value of the
//expression.
//
// Note that:
//
//
// The valid operators are '+', '-', '*', and '/'.
// Each operand may be an integer or another expression.
// The division between two integers always truncates toward zero.
// There will not be any division by zero.
// The input represents a valid arithmetic expression in a reverse polish
//notation.
// The answer and all the intermediate calculations can be represented in a 32-
//bit integer.
//
//
//
// Example 1:
//
//
//Input: tokens = ["2","1","+","3","*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9
//
//
// Example 2:
//
//
//Input: tokens = ["4","13","5","/","+"]
//Output: 6
//Explanation: (4 + (13 / 5)) = 6
//
//
// Example 3:
//
//
//Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//Output: 22
//Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22
//
//
//
// Constraints:
//
//
// 1 <= tokens.length <= 10⁴
// tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the
//range [-200, 200].
//
//
// Related Topics 栈 数组 数学 👍 967 👎 0

import java.util.Stack;

//Evaluate Reverse Polish Notation
public class Q150_EvaluateReversePolishNotation{
    public static void main(String[] args) {
        Solution solution = new Q150_EvaluateReversePolishNotation().new Solution();
        // 测试用例
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        System.out.println(solution.evalRPN(tokens1)); // 输出: 9

        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(solution.evalRPN(tokens2)); // 输出: 6

        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(solution.evalRPN(tokens3)); // 输出: 22

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();

            for (String token : tokens) {
                if (isOperator(token)) {
                    int b = stack.pop();
                    int a = stack.pop();
                    int result = applyOperator(a, b, token);
                    stack.push(result);
                } else {
                    stack.push(Integer.parseInt(token));
                }
            }

            return stack.pop();
        }

        private boolean isOperator(String token) {
            return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
        }

        private int applyOperator(int a, int b, String operator) {
            switch (operator) {
                case "+":
                    return a + b;
                case "-":
                    return a - b;
                case "*":
                    return a * b;
                case "/":
                    return a / b;
                default:
                    throw new IllegalArgumentException("Invalid operator: " + operator);
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
