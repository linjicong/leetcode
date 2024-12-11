//Given the root of a binary tree, return the inorder traversal of its nodes'
//values.
//
//
// Example 1:
//
//
// Input: root = [1,null,2,3]
//
//
// Output: [1,3,2]
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
// Output: [4,2,6,5,7,1,3,9,8]
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
//Follow up: Recursive solution is trivial, could you do it iteratively?
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 2164 👎 0

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

//Binary Tree Inorder Traversal
public class Q94_BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new Q94_BinaryTreeInorderTraversal().new Solution();
        // 测试用例
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderHelper(node.left, result);  // 左子树
        result.add(node.val);             // 根节点
        inorderHelper(node.right, result); // 右子树
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class TreeNode {
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
}
