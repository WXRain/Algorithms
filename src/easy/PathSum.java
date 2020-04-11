/**
 * 
 */
package easy;

import easy.MaxDepthOfBinaryTree.TreeNode;

/**
 * @author wangxinyu
 *
 */
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		int mid = root.val;
		if(root.left == null && root.right == null && sum == mid) return true;
		boolean l = hasPathSum(root.left, sum - root.val);
		boolean r = hasPathSum(root.right, sum - root.val);
		return l || r;
    }
}
