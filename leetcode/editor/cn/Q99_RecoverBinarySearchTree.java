//You are given the root of a binary search tree (BST), where the values of
//exactly two nodes of the tree were swapped by mistake. Recover the tree without
//changing its structure.
//
//
// Example 1:
//
//
//Input: root = [1,3,null,null,2]
//Output: [3,1,null,null,2]
//Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3
//makes the BST valid.
//
//
// Example 2:
//
//
//Input: root = [3,1,4,null,null,2]
//Output: [2,1,4,null,null,3]
//Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2
//and 3 makes the BST valid.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [2, 1000].
// -2³¹ <= Node.val <= 2³¹ - 1
//
//
//
//Follow up: A solution using
//O(n) space is pretty straight-forward. Could you devise a constant
//O(1) space solution?
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 980 👎 0

//Recover Binary Search Tree
public class Q99_RecoverBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new Q99_RecoverBinarySearchTree().new Solution();
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
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        // 中序遍历找到两个需要交换的节点
        inorderTraversal(root);

        // 交换这两个节点的值
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // 遍历左子树
        inorderTraversal(node.left);

        // 检查当前节点和前一个节点的关系
        if (prev != null && node.val < prev.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }

        // 更新前一个节点
        prev = node;

        // 遍历右子树
        inorderTraversal(node.right);
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
