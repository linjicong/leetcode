//给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,1,2]
//输出：[1,2]
//
//
// 示例 2：
//
//
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
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
// Related Topics 链表 👍 804 👎 0

public class Q83_RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new Q83_RemoveDuplicatesFromSortedList().new Solution();
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
            //链表为空或者只有一个节点，直接返回
            if (head == null || head.next == null) {
                return head;
            }
            //用来遍历的节点
            ListNode cur = head;
            //哑巴节点,始终指向头节点
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            //前驱节点，用来串联链表
            ListNode pre = dummy;
            while (cur != null) {
                //循环，直到当前节点的val值不等于下一个节点，否则都废弃，只保留最后一个重复的节点
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                //串联链表
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
            //哑巴节点的下一个节点就是新链表的头节点
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
