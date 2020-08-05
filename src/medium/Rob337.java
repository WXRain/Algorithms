package medium;

import medium.RightSideView.TreeNode;

/**
 *在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Rob337 {
    public int rob(TreeNode root) {
        int[] res = find(root);
        return Math.max(res[0], res[1]);
    }

    public int[] find(TreeNode r) {
        if (r == null) return new int[2];
        //分别计算左右节点的结果
        int[] left = find(r.left);
        int[] right = find(r.right);
        int[] res = new int[2];
        //res[0]表示不偷本节点，则结果为左节点的最大值加上右节点的最大值
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //res[1]表示偷本节点，则结果为本节点值加上不偷左节点加上不偷右节点
        res[1] = r.val + left[0] + right[0];
        return res;
    }
}
