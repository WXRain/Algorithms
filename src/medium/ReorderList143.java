package medium;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorderList143 {
    public static void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        if (head == null) return;
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) break;
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode f = new ListNode(2);
        ListNode s = new ListNode(3);
        ListNode fo = new ListNode(4);
        head.next = f;
        f.next = s;
        s.next = fo;
        reorderList(head);
    }
}
