//Given the head of a linked list, return the list after sorting it in
//ascending order.
//
//
// Example 1:
//
//
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]
//
//
// Example 2:
//
//
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]
//
//
// Example 3:
//
//
//Input: head = []
//Output: []
//
//
//
// Constraints:
//
//
// The number of nodes in the list is in the range [0, 5 * 10⁴].
// -10⁵ <= Node.val <= 10⁵
//
//
//
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.
//e. constant space)?
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2415 👎 0

//Sort List
public class Q148_SortList{
    public static void main(String[] args) {
        Solution solution = new Q148_SortList().new Solution();
        // 测试用例

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 使用快慢指针找到链表的中间节点
        ListNode mid = getMiddle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        // 递归排序左右两部分
        left = sortList(left);
        right = sortList(right);

        // 合并排序后的两部分
        return merge(left, right);
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        // 将剩余部分连接到结果链表
        if (left != null) {
            current.next = left;
        }
        if (right != null) {
            current.next = right;
        }

        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
