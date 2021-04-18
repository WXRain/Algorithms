package easy;

import easy.SameTree100.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 * <p>
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 * <p>
 * 4
 * /   \
 * 2      6
 * / \
 * 1   3
 * <p>
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 * <p>
 * <p>
 * 注意：
 * <p>
 * 二叉树的大小范围在 2 到 100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDiffInBST783 {
    public int minDiffInBST(TreeNode root) {
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
