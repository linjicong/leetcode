//Given a binary tree
//
//
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//}
//
//
// Populate each next pointer to point to its next right node. If there is no
//next right node, the next pointer should be set to NULL.
//
// Initially, all next pointers are set to NULL.
//
//
// Example 1:
//
//
//Input: root = [1,2,3,4,5,null,7]
//Output: [1,#,2,3,#,4,5,7,#]
//Explanation: Given the above binary tree (Figure A), your function should
//populate each next pointer to point to its next right node, just like in Figure B.
//The serialized output is in level order as connected by the next pointers, with
//'#' signifying the end of each level.
//
//
// Example 2:
//
//
//Input: root = []
//Output: []
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 6000].
// -100 <= Node.val <= 100
//
//
//
// Follow-up:
//
//
// You may only use constant extra space.
// The recursive approach is fine. You may assume implicit stack space does not
//count as extra space for this problem.
//
//
// Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 888 👎 0

//Populating Next Right Pointers in Each Node II
public class Q117_PopulatingNextRightPointersInEachNodeIi{
    public static void main(String[] args) {
        Solution solution = new Q117_PopulatingNextRightPointersInEachNodeIi().new Solution();
        // 测试用例
    }
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node current = root;
        while (current != null) {
            Node dummyHead = new Node(0); // Dummy head for the next level
            Node pre = dummyHead; // Pointer to traverse the next level

            // Traverse the current level
            while (current != null) {
                if (current.left != null) {
                    pre.next = current.left;
                    pre = pre.next;
                }
                if (current.right != null) {
                    pre.next = current.right;
                    pre = pre.next;
                }
                current = current.next; // Move to the next node in the current level
            }

            // Move to the next level
            current = dummyHead.next;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
