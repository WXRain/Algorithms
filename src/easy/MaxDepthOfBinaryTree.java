/**
 * 
 */
package easy;

/**
 * @author wangxinyu
 *
 */
public class MaxDepthOfBinaryTree {
	static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
	public static int maxDepth(TreeNode root){
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1; 
	}
	public static void main(String[] args) {
		
	}
}
