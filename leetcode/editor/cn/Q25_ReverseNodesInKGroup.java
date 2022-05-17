//给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
//
// k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[2,1,4,3,5]
//
//
// 示例 2：
//
//
//
//
//输入：head = [1,2,3,4,5], k = 3
//输出：[3,2,1,4,5]
//
//
//
//提示：
//
//
// 链表中的节点数目为 n
// 1 <= k <= n <= 5000
// 0 <= Node.val <= 1000
//
//
//
//
// 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
//
//
//
// Related Topics 递归 链表 👍 1632 👎 0

public class Q25_ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new Q25_ReverseNodesInKGroup().new Solution();
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
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode swap = new ListNode(0);
            ListNode saveHead = swap;
            ListNode[] point = new ListNode[k];
            int flag = 0; //判断剩下的有没有k个
            while(head != null) {
                point[0] = head;
                for(int i=1; i<k; i++) {
                    if(point[i-1].next != null) point[i] = point[i-1].next;  //一边将指针指到相应的位置，一边判断是否够k个
                    else {
                        flag = 1; //不够k个
                        break;
                    }
                }
                if(flag == 1) {
                    swap.next = head;
                    break;
                }

                head = point[k-1].next;  //保存下一组的头节点
                for(int i=k-1; i>=0; i--) {
                    swap.next = point[i];
                    swap = swap.next;
                }
                swap.next = head;
            }
            return saveHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
