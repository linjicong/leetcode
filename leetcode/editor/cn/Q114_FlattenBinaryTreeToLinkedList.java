//Given the root of a binary tree, flatten the tree into a "linked list":
//
//
// The "linked list" should use the same TreeNode class where the right child
//pointer points to the next node in the list and the left child pointer is always
//null.
// The "linked list" should be in the same order as a pre-order traversal of
//the binary tree.
//
//
//
// Example 1:
//
//
//Input: root = [1,2,5,3,4,null,6]
//Output: [1,null,2,null,3,null,4,null,5,null,6]
//
//
// Example 2:
//
//
//Input: root = []
//Output: []
//
//
// Example 3:
//
//
//Input: root = [0]
//Output: [0]
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 2000].
// -100 <= Node.val <= 100
//
//
//
//Follow up: Can you flatten the tree in-place (with
//O(1) extra space)?
//
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1759 👎 0

//Flatten Binary Tree to Linked List
public class Q114_FlattenBinaryTreeToLinkedList{
    public static void main(String[] args) {
        Solution solution = new Q114_FlattenBinaryTreeToLinkedList().new Solution();
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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // Flatten the left subtree
        flatten(root.left);
        // Flatten the right subtree
        flatten(root.right);

        // Store the right subtree
        TreeNode tempRight = root.right;

        // Move the left subtree to the right
        root.right = root.left;
        root.left = null;

        // Find the rightmost node of the new right subtree
        while (root.right != null) {
            root = root.right;
        }

        // Attach the original right subtree to the rightmost node
        root.right = tempRight;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
