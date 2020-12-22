package medium;

import medium.RightSideView.TreeNode;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class ZigzagLevelOrder103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode lastlayer = root;
        TreeNode currlayer = root;
        boolean isRe = false;
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode x = q.poll();
            if (x.left != null) {
                q.offer(x.left);
                currlayer = x.left;
            }
            if (x.right != null) {
                q.offer(x.right);
                currlayer = x.right;
            }
            if (isRe) {
                s.push(x);
            } else {
                list.add(x.val);
            }
            if (x.equals(lastlayer)) {
                lastlayer = currlayer;
                while (!s.isEmpty()) {
                    list.add(s.pop().val);
                }
                res.add(list);
                list = new ArrayList<>();
                isRe = !isRe;
            }
        }
        return res;
    }
}
