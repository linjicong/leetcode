//Given the head of a singly linked list and two integers left and right where
//left <= right, reverse the nodes of the list from position left to position
//right, and return the reversed list.
//
//
// Example 1:
//
//
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
//
//
// Example 2:
//
//
//Input: head = [5], left = 1, right = 1
//Output: [5]
//
//
//
// Constraints:
//
//
// The number of nodes in the list is n.
// 1 <= n <= 500
// -500 <= Node.val <= 500
// 1 <= left <= right <= n
//
//
//
//Follow up: Could you do it in one pass?
//
// Related Topics 链表 👍 1894 👎 0

//Reverse Linked List II
public class Q92_ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new Q92_ReverseLinkedListIi().new Solution();
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move prev to the node before the start of the sublist
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        // Start is the first node in the sublist to be reversed
        ListNode start = prev.next;
        // Then is the node after start
        ListNode then = start.next;

        // Reverse the sublist between left and right
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
