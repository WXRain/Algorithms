package medium;

import medium.RightSideView.TreeNode;

/**
 *给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedListToBST109 {
    public TreeNode sortedListToBST(ListNode head) {
        int num = 0;
        ListNode l = head;
        while (l != null) {
            num++;
            l = l.next;
        }
        if (num == 0) return new TreeNode();
        int[] list = new int[num];
        l = head;
        num = 0;
        while (l != null) {
            list[num] = l.val;
            num++;
            l = l.next;
        }
        TreeNode result = generateTree(list, 0, list.length);
        return result;
    }

    private TreeNode generateTree(int[] list, int start, int end) {
        if (start >= end) return null;
        int middle = (start + end) / 2;
        TreeNode node = new TreeNode(list[middle]);
        node.left = generateTree(list, start, middle);
        node.right = generateTree(list, middle + 1, end);
        return node;
    }
}
