package easy;

import easy.MaxDepthOfBinaryTree104.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreePaths257 {

    private List<Integer> temp = new ArrayList<>();
    private List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        path(root);
        return result;
    }

    private void path(TreeNode root) {
        if(root == null) return;
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            String res = "";
            for (int num : temp) {
                res += num;
                res += "->";
            }
            res = res.substring(0, res.length() - 2);
            result.add(res);
            temp.remove(temp.size() - 1);
            return;
        }
        if(root.left != null){
            path(root.left);
        }
        if(root.right != null){
            path(root.right);
        }
        temp.remove(temp.size() - 1);
    }
}
