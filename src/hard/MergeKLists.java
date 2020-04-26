package hard;
/**
 * 
 *@author rain
 *
合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKLists {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) return null;
		if(lists.length == 1) return lists[0];
		ListNode result = null;
		for(int i = 0; i < lists.length; i++){
			result = mergeTwoLists(result, lists[i]);
		}
		return result;
    }
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode result = new ListNode(0);
		ListNode temp = result;
		ListNode i = l1;
		ListNode j = l2;
		while(i != null && j != null){
			if(i.val <= j.val){
				temp.next = new ListNode(i.val);
				temp = temp.next;
				i = i.next;
			}else{
				temp.next = new ListNode(j.val);
				temp = temp.next;
				j = j.next;
			}
		}
		while(i != null){
			temp.next = new ListNode(i.val);
			temp = temp.next;
			i = i.next;
		}
		while(j != null){
			temp.next = new ListNode(j.val);
			temp = temp.next;
			j = j.next;
		}
		return result.next;
	}
}
