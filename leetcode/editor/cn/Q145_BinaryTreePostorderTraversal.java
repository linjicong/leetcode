//Given the root of a binary tree, return the postorder traversal of its nodes'
//values.
//
//
// Example 1:
//
//
// Input: root = [1,null,2,3]
//
//
// Output: [3,2,1]
//
// Explanation:
//
//
//
// Example 2:
//
//
// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
//
//
// Output: [4,6,7,5,2,9,8,3,1]
//
// Explanation:
//
//
//
// Example 3:
//
//
// Input: root = []
//
//
// Output: []
//
// Example 4:
//
//
// Input: root = [1]
//
//
// Output: [1]
//
//
// Constraints:
//
//
// The number of the nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
//
//
//
//Follow up: Recursive solution is trivial, could you do it iteratively?
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1214 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Binary Tree Postorder Traversal
public class Q145_BinaryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new Q145_BinaryTreePostorderTraversal().new Solution();
        // 测试用例

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null;
        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right != null && lastVisited != peekNode.right) {
                    current = peekNode.right;
                } else {
                    result.add(peekNode.val);
                    lastVisited = stack.pop();
                }
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
