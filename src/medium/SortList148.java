package medium;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 进阶：
 * <p>
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortList148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode hhead = new ListNode();
        hhead.next = head;
        ListNode last = head, curr = last.next;
        while (curr != null) {
            if (last.val <= curr.val) {
                last = last.next;
            } else {
                ListNode l = hhead;
                while (l.next.val <= curr.val) {
                    l = l.next;
                }
                last.next = curr.next;
                curr.next = l.next;
                l.next = curr;
            }
            curr = last.next;
        }
        return hhead.next;
    }
}
