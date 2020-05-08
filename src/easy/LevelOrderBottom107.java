package easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import easy.MaxDepthOfBinaryTree104.TreeNode;
import util.Utils;
/**
 * 
 *@author rain
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrderBottom107 {
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		if(root == null) return new LinkedList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		List<Integer> list = new LinkedList<Integer>();
		TreeNode last = root;
		TreeNode tempLast = root;
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			list.add(temp.val);
			if(temp.left != null){
				queue.add(temp.left);
				tempLast = temp.left;
			}
			if(temp.right != null){
				queue.add(temp.right);
				tempLast = temp.right;
			}
			if(temp.equals(last)){
				result.addFirst(list);
				list = new LinkedList<Integer>();
				last = tempLast;
			}
		}
		return result;
    }
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		Utils.printLists(levelOrderBottom(root));
	}
}
