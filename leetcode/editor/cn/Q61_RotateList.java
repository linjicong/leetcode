//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
//
//
// 示例 2：
//
//
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 500] 内
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 10⁹
//
// Related Topics 链表 双指针 👍 773 👎 0

public class Q61_RotateList {
    public static void main(String[] args) {
        Solution solution = new Q61_RotateList().new Solution();
        solution.rotateRight(new ListNode(1), 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) return head;
            ListNode cur = head;
            int len = 1;
            while (cur.next != null) {
                len++;
                cur = cur.next;
            }
            k = k % len;
            if (k == 0) return head;
            cur.next = head;
            for (int i = 0; i < len - k ; i++) {
                cur = cur.next;
            }
            ListNode newHead = cur.next;
            cur.next = null;
            return newHead;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
