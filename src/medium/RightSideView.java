package medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
/**
 * 
 *@author rain
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:

输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
  
 */
public class RightSideView {
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(){}
	    TreeNode(int x) { val = x; }
	}
    public List<Integer> rightSideView(TreeNode root) {
    		if(root == null) return new LinkedList<Integer>();
    		List<Integer> result = new LinkedList<Integer>();
    		Deque<TreeNode> queue = new LinkedList<TreeNode>();
    		queue.offer(root);
    		TreeNode rightest = root;
    		while(!queue.isEmpty()){
    			TreeNode x = queue.poll();
    			if(x.left != null){
    				queue.offer(x.left);
    			}
    			if(x.right != null){
    				queue.offer(x.right);
    			}
    			if(x.equals(rightest)){
    				result.add(x.val);
    				rightest = queue.peekLast();
    			}
    		}
    		return result;
    }
}
