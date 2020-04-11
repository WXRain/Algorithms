/**
 * 
 */
package easy;

import easy.MaxDepthOfBinaryTree.TreeNode;

/**
 * @author wangxinyu
 *
 */
public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(depth(root.left) - depth(root.right)) <= 1) {
        		return isBalanced(root.left) && isBalanced(root.right);
        }
        else return false;
    }
	public int depth(TreeNode root){
		if(root == null) return 0;
		int l = depth(root.left);
		int r = depth(root.right);
		return l > r ? l+1 : r+1;
	}
}
