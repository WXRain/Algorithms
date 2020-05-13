package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import medium.RightSideView.TreeNode;

public class LevelOrder102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null) return new LinkedList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode last = root;
		TreeNode temp = root;
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		while(!queue.isEmpty()){
			TreeNode t = queue.poll();
			list.add(t.val);
			if(t.left != null){
				queue.add(t.left);
				temp = t.left;
			}
			if(t.right != null){
				queue.add(t.right);
				temp = t.right;
			}
			if(t == last){
				result.add(list);
				list = new LinkedList<Integer>();
				last = temp;
			}
		}
		return result;
    }
}
