//A path in a binary tree is a sequence of nodes where each pair of adjacent
//nodes in the sequence has an edge connecting them. A node can only appear in the
//sequence at most once. Note that the path does not need to pass through the root.
//
//
// The path sum of a path is the sum of the node's values in the path.
//
// Given the root of a binary tree, return the maximum path sum of any non-
//empty path.
//
//
// Example 1:
//
//
//Input: root = [1,2,3]
//Output: 6
//Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
//
//
//
// Example 2:
//
//
//Input: root = [-10,9,20,null,null,15,7]
//Output: 42
//Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7
//= 42.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 3 * 10⁴].
// -1000 <= Node.val <= 1000
//
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 2326 👎 0

//Binary Tree Maximum Path Sum
public class Q124_BinaryTreeMaximumPathSum{
    public static void main(String[] args) {
        Solution solution = new Q124_BinaryTreeMaximumPathSum().new Solution();
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
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 计算左子树和右子树的最大贡献值
        int leftGain = Math.max(dfs(node.left), 0);
        int rightGain = Math.max(dfs(node.right), 0);

        // 计算经过当前节点的最大路径和
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新全局最大路径和
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回当前节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
