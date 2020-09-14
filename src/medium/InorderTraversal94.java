package medium;

import medium.RightSideView.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InorderTraversal94 {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            inorder(root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            inorder(root.right);
        }
    }


}
