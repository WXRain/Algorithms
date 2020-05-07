/**
 * 
 */
package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rain
 *
 */
public class SymmetricTree101 {
	class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public static boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
        		TreeNode t1 = queue.poll();
        		TreeNode t2 = queue.poll();
        		if(t1==null && t2==null) continue;
        		if(t1==null || t2==null) return false;
        		if(t1.val != t2.val) return false;
        		queue.offer(t1.left);
        		queue.offer(t2.right);
        		queue.offer(t1.right);
        		queue.offer(t2.left);
        }
        return true;
    }
	
}
