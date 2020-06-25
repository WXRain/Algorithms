package easy;

import java.util.HashSet;
import java.util.Set;

import easy.DeleteDuplicates83.ListNode;

/**
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * 
 * 示例1:
 * 
 * 输入：[1, 2, 3, 3, 2, 1] 输出：[1, 2, 3] 示例2:
 * 
 * 输入：[1, 1, 1, 1, 2] 输出：[1, 2] 提示：
 * 
 * 链表长度在[0, 20000]范围内。 链表元素在[0, 20000]范围内。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author rain
 */
public class RemoveDuplicateNodes02_01 {
	public ListNode removeDuplicateNodes(ListNode head) {
		Set<Integer> set = new HashSet<Integer>();
		if (head == null)
			return null;
		set.add(head.val);
		ListNode first = head.next, last = head;
		while (first != null) {
			boolean judge = set.add(first.val);
			if (!judge) {
				last.next = first.next;
				first = last.next;
			} else {
				first = first.next;
				last = last.next;
			}

		}
		return head;
	}
}
