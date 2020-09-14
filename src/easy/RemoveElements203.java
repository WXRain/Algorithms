package easy;

import easy.DeleteDuplicates83.ListNode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveElements203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode first = head;
        ListNode second = h;
        while (first != null) {
            if (first.val == val) {
                second.next = first.next;
                first = second.next;
            } else {
                first = first.next;
                second = second.next;
            }
        }
        return h.next;
    }
}
