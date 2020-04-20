/**
 * 
 */
package easy;

import easy.MaxDepthOfBinaryTree.TreeNode;

/**
 * @author rain
 *
 */
public class ConvertSortedArraytoBinarySearchTree {
	public static TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length == 0) return null;
		return transfer(0, nums.length-1, nums);
    }
	public static TreeNode transfer(int start, int end, int[] nums){
		int middle = (end-start) / 2;
        TreeNode root = new TreeNode(nums[start + middle]);
        if(start + middle != start){
        		root.left = transfer(start, start + middle-1, nums);
        }
        if(start + middle != end){
        		root.right = transfer(start + middle +1, end, nums);
        }
        return root;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		sortedArrayToBST(nums);
	}
}
