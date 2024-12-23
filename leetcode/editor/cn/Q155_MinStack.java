//Design a stack that supports push, pop, top, and retrieving the minimum
//element in constant time.
//
// Implement the MinStack class:
//
//
// MinStack() initializes the stack object.
// void push(int val) pushes the element val onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.
//
//
// You must implement a solution with O(1) time complexity for each function.
//
//
// Example 1:
//
//
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
//
//
//
// Constraints:
//
//
// -2³¹ <= val <= 2³¹ - 1
// Methods pop, top and getMin operations will always be called on non-empty
//stacks.
// At most 3 * 10⁴ calls will be made to push, pop, top, and getMin.
//
//
// Related Topics 栈 设计 👍 1859 👎 0

import java.util.Stack;

//Min Stack
public class Q155_MinStack{
    public static void main(String[] args) {
        MinStack solution = new Q155_MinStack().new MinStack();
        // 测试用例

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                int val = stack.pop();
                if (val == minStack.peek()) {
                    minStack.pop();
                }
            }
        }

        public int top() {
            if (!stack.isEmpty()) {
                return stack.peek();
            }
            throw new IllegalStateException("Stack is empty");
        }

        public int getMin() {
            if (!minStack.isEmpty()) {
                return minStack.peek();
            }
            throw new IllegalStateException("Stack is empty");
        }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
