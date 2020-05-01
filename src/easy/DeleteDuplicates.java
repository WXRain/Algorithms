/**
 * 
 */
package easy;

/**
 * @author rain
 *
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class DeleteDuplicates {
	static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	}	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) return head;
        ListNode first = head, second = head.next;
        while(second != null){
        		if(first.val == second.val){
        			first.next = second.next;
        			second = first.next;
        			continue;
        		}
        		first = second;
        		second = second.next;
        }
        
        return head;
    }
	
	
}
