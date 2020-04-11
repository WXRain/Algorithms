/**
 * 
 */
package easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import easy.MaxDepthOfBinaryTree.TreeNode;

/**
 * @author wangxinyu
 *
 */
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		if(root == null) return new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        TreeNode find = root;
        while(!queue.isEmpty()){
        		List<Integer> list = new LinkedList<Integer>();
        		TreeNode last = find;
        		TreeNode t;
        		do{
        			t = queue.poll();
        			list.add(t.val);
        			if(t.left != null){
        				queue.offer(t.left);
        				find = t.left;
        			}
        			if(t.right != null){
        				queue.offer(t.right);
        				find = t.right;
        			}
        		}while(!(t==last));
        		stack.push(list);
        }
        while(!stack.isEmpty()){
        		result.add(stack.pop());
        }
        return result;
    }
}
