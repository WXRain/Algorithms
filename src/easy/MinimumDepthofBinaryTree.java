/**
 * 
 */
package easy;

import easy.MaxDepthOfBinaryTree.TreeNode;

/**
 * @author rain
 *
 */
public class MinimumDepthofBinaryTree {
	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		else return depth(root);
    }
	public int depth(TreeNode root){
		if(root == null) return Integer.MAX_VALUE;
		if(root.left == null && root.right == null) return 1;
		if(root.left == null) return minDepth(root.right) + 1;
		if(root.right == null) return minDepth(root.left) + 1;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        return l < r ? l+1 : r+1;
	}
}
