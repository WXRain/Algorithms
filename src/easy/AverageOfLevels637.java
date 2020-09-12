package easy;

import easy.MaxDepthOfBinaryTree104.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *  
 *
 * 提示：
 *
 * 节点值的范围在32位有符号整数范围内。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AverageOfLevels637 {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode cur = root;
        TreeNode last = root;
        long total = 0;
        int num = 0;
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            total += temp.val;
            num++;
            if (temp.left != null) {
                q.offer(temp.left);
                cur = temp.left;
            }
            if (temp.right != null) {
                q.offer(temp.right);
                cur = temp.right;
            }
            if (temp.equals(last)) {
                double d = total / (double) num;
                res.add(d);
                total = 0;
                num = 0;
                last = cur;
            }
        }
        return res;
    }
}
