//You are given the head of a singly linked-list. The list can be represented
//as:
//
//
//L0 → L1 → … → Ln - 1 → Ln
//
//
// Reorder the list to be on the following form:
//
//
//L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
//
//
// You may not modify the values in the list's nodes. Only nodes themselves may
//be changed.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4]
//Output: [1,4,2,3]
//
//
// Example 2:
//
//
//Input: head = [1,2,3,4,5]
//Output: [1,5,2,4,3]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range [1, 5 * 10⁴].
// 1 <= Node.val <= 1000
//
//
// Related Topics 栈 递归 链表 双指针 👍 1547 👎 0

//Reorder List
public class Q143_ReorderList{
    public static void main(String[] args) {
        Solution solution = new Q143_ReorderList().new Solution();
        // 测试用例

    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        ListNode prev = null;
        ListNode current = slow;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        // Step 3: Merge the two halves
        ListNode first = head;
        ListNode second = prev;
        while (second.next != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
