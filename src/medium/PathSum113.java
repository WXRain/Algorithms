package medium;

import medium.RightSideView.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum113 {
    Stack<Integer> stack = new Stack<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        findPath(root, sum);
        return res;
    }

    private void findPath(TreeNode root, int sum) {
        if (root == null) return;
        stack.push(root.val);
        if (root.left != null) findPath(root.left, sum - root.val);
        if (root.right != null) findPath(root.right, sum - root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> temp = new ArrayList<>(stack);
            res.add(temp);
        }
        stack.pop();
    }

}
