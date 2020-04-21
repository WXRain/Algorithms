package medium;
/**
 * 
 *@author rain
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoListAdd {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode node1 = l1, node2 = l2;
		ListNode result = new ListNode((node1.val + node2.val) % 10);
		ListNode m = result;
		int jw = (node1.val + node2.val) / 10;
		node1 = node1.next;
		node2 = node2.next;
		while(node1 != null && node2 != null){
			ListNode x = new ListNode((node1.val + node2.val + jw) % 10 );
			m.next = x;
			m = m.next;
			jw = (node1.val + node2.val + jw) / 10;
			node1 = node1.next;
			node2 = node2.next;
		}
		if(node1 == null){
			while(node2 != null){
				ListNode x = new ListNode((node2.val + jw) % 10);
				jw = (node2.val + jw) / 10;
				m.next = x;
				m = m.next;
				node2 = node2.next;
			}
		}
		if(node2 == null){
			while(node1 != null){
				ListNode x = new ListNode((node1.val + jw) % 10);
				jw = (node1.val + jw) / 10;
				m.next = x;
				m = m.next;
				node1 = node1.next;
			}
		}
		if(node1 == null && node2 == null && jw != 0){
			ListNode x = new ListNode(jw);
			m.next = x;
			m = m.next;
		}
		m.next = null;
		return result;
    }
}
