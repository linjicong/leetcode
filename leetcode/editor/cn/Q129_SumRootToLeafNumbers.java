//You are given the root of a binary tree containing digits from 0 to 9 only.
//
// Each root-to-leaf path in the tree represents a number.
//
//
// For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
//
//
// Return the total sum of all root-to-leaf numbers. Test cases are generated
//so that the answer will fit in a 32-bit integer.
//
// A leaf node is a node with no children.
//
//
// Example 1:
//
//
//Input: root = [1,2,3]
//Output: 25
//Explanation:
//The root-to-leaf path 1->2 represents the number 12.
//The root-to-leaf path 1->3 represents the number 13.
//Therefore, sum = 12 + 13 = 25.
//
//
// Example 2:
//
//
//Input: root = [4,9,0,5,1]
//Output: 1026
//Explanation:
//The root-to-leaf path 4->9->5 represents the number 495.
//The root-to-leaf path 4->9->1 represents the number 491.
//The root-to-leaf path 4->0 represents the number 40.
//Therefore, sum = 495 + 491 + 40 = 1026.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 1000].
// 0 <= Node.val <= 9
// The depth of the tree will not exceed 10.
//
//
// Related Topics 树 深度优先搜索 二叉树 👍 774 👎 0

//Sum Root to Leaf Numbers
public class Q129_SumRootToLeafNumbers{
    public static void main(String[] args) {
        Solution solution = new Q129_SumRootToLeafNumbers().new Solution();
        // 测试用例
        TreeNode root1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(solution.sumNumbers(root1)); // 输出: 25

        TreeNode root2 = new TreeNode(4,
                new TreeNode(9,
                        new TreeNode(5),
                        new TreeNode(1)),
                new TreeNode(0));
        System.out.println(solution.sumNumbers(root2)); // 输出: 1026

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
static class TreeNode {
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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentNumber) {
        if (node == null) {
            return 0;
        }

        // 更新当前路径的数字
        currentNumber = currentNumber * 10 + node.val;

        // 如果是叶子节点，返回当前路径的数字
        if (node.left == null && node.right == null) {
            return currentNumber;
        }

        // 递归计算左子树和右子树的路径和
        int leftSum = dfs(node.left, currentNumber);
        int rightSum = dfs(node.right, currentNumber);

        // 返回左右子树路径和的总和
        return leftSum + rightSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
