package easy;

import easy.DeleteDuplicates83.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 */
public class IsPalindrome234 {
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode l = head;
        while (l != null) {
            list.add(l.val);
            l = l.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-129);
        ListNode ne = new ListNode(-129);
        head.next = ne;
        isPalindrome(head);
    }
}
