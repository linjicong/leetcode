//Given a binary tree, find its minimum depth.
//
// The minimum depth is the number of nodes along the shortest path from the
//root node down to the nearest leaf node.
//
// Note: A leaf is a node with no children.
//
//
// Example 1:
//
//
//Input: root = [3,9,20,null,null,15,7]
//Output: 2
//
//
// Example 2:
//
//
//Input: root = [2,null,3,null,4,null,5,null,6]
//Output: 5
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 10⁵].
// -1000 <= Node.val <= 1000
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1249 👎 0

import java.util.LinkedList;
import java.util.Queue;

//Minimum Depth of Binary Tree
public class Q111_MinimumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new Q111_MinimumDepthOfBinaryTree().new Solution();
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
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // Check if it's a leaf node
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }

                // Add child nodes to the queue
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            depth++;
        }

        return depth; // This line should never be reached if input is valid
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
