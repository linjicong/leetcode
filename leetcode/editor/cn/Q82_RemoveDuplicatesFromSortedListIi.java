//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
//
//
// 示例 2：
//
//
//输入：head = [1,1,1,2,3]
//输出：[2,3]
//
//
//
//
// 提示：
//
//
// 链表中节点数目在范围 [0, 300] 内
// -100 <= Node.val <= 100
// 题目数据保证链表已经按升序 排列
//
// Related Topics 链表 双指针 👍 914 👎 0

public class Q82_RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new Q82_RemoveDuplicatesFromSortedListIi().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        solution.deleteDuplicates(head);
        System.out.println(head);
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            ListNode fast = head, slow = dummy;
            slow.next = fast;
            while (fast != null) {
                while (fast.next != null && (fast.val == fast.next.val)) { //fast在相同的最后一个.4
                    fast = fast.next;
                }
                if (slow.next != fast) { //slow不动,说明fast有重复,跳过
                    slow.next = fast.next;
                    fast = fast.next;
                } else {
                    //向前移
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            return dummy.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
