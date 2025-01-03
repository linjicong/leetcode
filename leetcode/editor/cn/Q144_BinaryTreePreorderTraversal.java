//Given the root of a binary tree, return the preorder traversal of its nodes'
//values.
//
//
// Example 1:
//
//
// Input: root = [1,null,2,3]
//
//
// Output: [1,2,3]
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
// Output: [1,2,4,5,6,7,3,8,9]
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
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
//
//
//
// Follow up: Recursive solution is trivial, could you do it iteratively?
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1301 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Binary Tree Preorder Traversal
public class Q144_BinaryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new Q144_BinaryTreePreorderTraversal().new Solution();
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            // Push right child first so that left child is processed first
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
