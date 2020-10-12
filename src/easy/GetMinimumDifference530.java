package easy;

import easy.MaxDepthOfBinaryTree104.TreeNode;

import java.util.*;

/**
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetMinimumDifference530 {

    public int getMinimumDifference(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            result.add(t.val);
            if (t.left != null) q.offer(t.left);
            if (t.right != null) q.offer(t.right);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.size(); j++) {
                if (i == j) continue;
                int sub = Math.abs(result.get(i) - result.get(j));
                if (sub < min) min = sub;
            }
        }
        return min;
    }
}
