package medium;

/**
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 *
 *
 * 示例：
 *
 * 输入：head = 1->4->3->2->5->2, x = 3
 * 输出：1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Partition86 {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode s = small;
        ListNode big = new ListNode(0);
        ListNode b = big;
        while (head != null) {
            ListNode l = head.next;
            if (head.val < x) {
                s.next = head;
                head.next = null;
                s = s.next;
            } else {
                b.next = head;
                head.next = null;
                b = b.next;
            }
            head = l;
        }
        s.next = big.next;
        return small.next;
    }
}
