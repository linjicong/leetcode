//Given two integer arrays inorder and postorder where inorder is the inorder
//traversal of a binary tree and postorder is the postorder traversal of the same
//tree, construct and return the binary tree.
//
//
// Example 1:
//
//
//Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//Output: [3,9,20,null,null,15,7]
//
//
// Example 2:
//
//
//Input: inorder = [-1], postorder = [-1]
//Output: [-1]
//
//
//
// Constraints:
//
//
// 1 <= inorder.length <= 3000
// postorder.length == inorder.length
// -3000 <= inorder[i], postorder[i] <= 3000
// inorder and postorder consist of unique values.
// Each value of postorder also appears in inorder.
// inorder is guaranteed to be the inorder traversal of the tree.
// postorder is guaranteed to be the postorder traversal of the tree.
//
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1291 👎 0

import java.util.HashMap;
import java.util.Map;

//Construct Binary Tree from Inorder and Postorder Traversal
public class Q106_ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new Q106_ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        // 测试用例
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = solution.buildTree(inorder, postorder);
        printTree(root);

    }
    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
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
// Definition for a binary tree node.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            // empty param
            return null;
        }

        int inLen = inorder.length;
        int postLen = postorder.length;

        if (inLen != postLen) {
            // inValid param
            return null;
        }

        // 只有一个元素
        if (inLen == 1) {
            return new TreeNode(inorder[0]);
        }

        return buildTree(inorder, 0, inLen-1, postorder, 0, postLen-1);
    }

    private TreeNode buildTree(int[] inOrder, int inBegin, int inEnd,
                               int[] postOrder, int postBegin, int postEnd) {
        if (inBegin > inEnd || postBegin > postEnd) {
            return null;
        }

        // 1、根节点的值
        int rootVal = postOrder[postEnd];

        // 2、找到该值在中序序列中的索引
        int rootIdxInOrder = -1;
        for (int i=inBegin; i<= inEnd; i++) {
            if (inOrder[i] == rootVal) {
                rootIdxInOrder = i;
                break;
            }
        }
        // 没找到，参数不合法，返回null
        if (rootIdxInOrder < 0) {
            return null;
        }

        // 3、生成头节点
        TreeNode root = new TreeNode(postOrder[postEnd]);

        // 只有一个元素
        if (inBegin == inEnd && postBegin == postEnd) {
            return root;
        }

        // 4、左子树长度
        int leftTreeLen = rootIdxInOrder - inBegin;

        // 5、后序遍历序列中，左子树遍历序列结束索引为postBegin + leftTreeLen - 1
        int postIdxLeftTreeEnd = postBegin + leftTreeLen - 1;

        // 6、递归处理左右子树

        // 挂接左右节点， 要去掉当前根节点的索引
        root.left = buildTree(inOrder, inBegin, rootIdxInOrder-1,
                postOrder, postBegin, postIdxLeftTreeEnd);
        root.right = buildTree(inOrder, rootIdxInOrder+1, inEnd,
                postOrder, postIdxLeftTreeEnd+1, postEnd-1);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
