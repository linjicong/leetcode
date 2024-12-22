//Given the head of a singly linked list, sort the list using insertion sort,
//and return the sorted list's head.
//
// The steps of the insertion sort algorithm:
//
//
// Insertion sort iterates, consuming one input element each repetition and
//growing a sorted output list.
// At each iteration, insertion sort removes one element from the input data,
//finds the location it belongs within the sorted list and inserts it there.
// It repeats until no input elements remain.
//
//
// The following is a graphical example of the insertion sort algorithm. The
//partially sorted list (black) initially contains only the first element in the
//list. One element (red) is removed from the input data and inserted in-place into
//the sorted list with each iteration.
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
//
// Constraints:
//
//
// The number of nodes in the list is in the range [1, 5000].
// -5000 <= Node.val <= 5000
//
//
// Related Topics 链表 排序 👍 683 👎 0

//Insertion Sort List
public class Q147_InsertionSortList{
    public static void main(String[] args) {
        Solution solution = new Q147_InsertionSortList().new Solution();
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode current = head.next;
        ListNode prev = head;

        while (current != null) {
            if (current.val < prev.val) {
                // 找到 current 应该插入的位置
                ListNode temp = dummyHead;
                while (temp.next.val < current.val) {
                    temp = temp.next;
                }
                // 插入 current 到 temp 和 temp.next 之间
                prev.next = current.next;
                current.next = temp.next;
                temp.next = current;
                current = prev.next;
            } else {
                // 如果 current 已经在正确的位置，继续下一个节点
                prev = current;
                current = current.next;
            }
        }

        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
