package easy;

import easy.MaxDepthOfBinaryTree.TreeNode;
/**
 * 
 *@author rain
 *
给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

示例 1:
给定的树 s:

     3
    / \
   4   5
  / \
 1   2
给定的树 t：

   4 
  / \
 1   2
返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

示例 2:
给定的树 s：

     3
    / \
   4   5
  / \
 1   2
    /
   0
给定的树 t：

   4
  / \
 1   2
返回 false。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subtree-of-another-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSubtree572 {
	//分解成对每个节点查找相等的树，所以单独定义一个判断相同树的函数。
	public static boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        return isSametree(s,t) || isSubtree(s.left, t) || isSametree(s.right, t);
    }
	public static boolean isSametree(TreeNode s, TreeNode t){
		if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        return s.val == t.val && isSametree(s.left, t.left) && isSubtree(s.right, t.right);
        		
	}
	
	public static void main(String[] args) {
		TreeNode t = new TreeNode(3);
		t.left = new TreeNode(1);
		t.right = new TreeNode(2);
		TreeNode s = new TreeNode(3);
		s.left = new TreeNode(4);
		s.right = new TreeNode(5);
		s.left.left = new TreeNode(1);
		s.right.left = new TreeNode(2);
		System.out.println(isSubtree(s, t));
	}
}
