//Given the root of a binary tree and an integer targetSum, return all root-to-
//leaf paths where the sum of the node values in the path equals targetSum. Each
//path should be returned as a list of the node values, not node references.
//
// A root-to-leaf path is a path starting from the root and ending at any leaf
//node. A leaf is a node with no children.
//
//
// Example 1:
//
//
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: [[5,4,11,2],[5,8,4,5]]
//Explanation: There are two paths whose sum equals targetSum:
//5 + 4 + 11 + 2 = 22
//5 + 8 + 4 + 5 = 22
//
//
// Example 2:
//
//
//Input: root = [1,2,3], targetSum = 5
//Output: []
//
//
// Example 3:
//
//
//Input: root = [1,2], targetSum = 0
//Output: []
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 5000].
// -1000 <= Node.val <= 1000
// -1000 <= targetSum <= 1000
//
//
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 1160 👎 0

import java.util.ArrayList;
import java.util.List;

//Path Sum II
public class Q113_PathSumIi{
    public static void main(String[] args) {
        Solution solution = new Q113_PathSumIi().new Solution();
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
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        dfs(root, targetSum, currentPath, result);
        return result;
    }

    private void dfs(TreeNode node, int remainingSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) {
            return;
        }

        // Add the current node to the path
        currentPath.add(node.val);

        // Check if it's a leaf node and the remaining sum is zero
        if (node.left == null && node.right == null && remainingSum == node.val) {
            result.add(new ArrayList<>(currentPath));
        } else {
            // Recur for left and right subtrees
            dfs(node.left, remainingSum - node.val, currentPath, result);
            dfs(node.right, remainingSum - node.val, currentPath, result);
        }

        // Backtrack: remove the current node from the path
        currentPath.remove(currentPath.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
