//Given an integer n, return all the structurally unique BST's (binary search
//trees), which has exactly n nodes of unique values from 1 to n. Return the answer
//in any order.
//
//
// Example 1:
//
//
//Input: n = 3
//Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]
//]
//
//
// Example 2:
//
//
//Input: n = 1
//Output: [[1]]
//
//
//
// Constraints:
//
//
// 1 <= n <= 8
//
//
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 👍 1587 👎 0

import java.util.ArrayList;
import java.util.List;

//Unique Binary Search Trees II
public class Q95_UniqueBinarySearchTreesIi{
    public static void main(String[] args) {
        Solution solution = new Q95_UniqueBinarySearchTreesIi().new Solution();
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++) {
            // 生成所有可能的左子树
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            // 生成所有可能的右子树
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 将左右子树组合成新的树
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = left;
                    currentTree.right = right;
                    allTrees.add(currentTree);
                }
            }
        }
        return allTrees;
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
