package medium;

import java.util.LinkedList;
import java.util.List;

import medium.RightSideView.TreeNode;
/**
 * 
 *@author rain
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
示例 2:

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/validate-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 
 */
public class IsValidBST98 {
	public static boolean isValidBST(TreeNode root) {
		if(root == null) return true;
		if(root.left == null && root.right == null) return true;
		List<Integer> list = new LinkedList<Integer>();
		list = midOrder(root, list);
		for(int i = 1; i < list.size(); i++){
			if(list.get(i) > list.get(i-1)) continue;
			else return false;
		}
		return true;
    }
	public static List<Integer> midOrder(TreeNode root, List<Integer> list){
		if(root == null) return list;
		if(root.left == null && root.right == null){
			list.add(root.val);
			return list;
		}
		list = midOrder(root.left, list);
		list.add(root.val);
		list = midOrder(root.right, list);
		return list;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left= null;
		root.right = new TreeNode(1);
		System.out.println(isValidBST(root));
	}
	/**
	 * 更简洁的方法
	public boolean isValidBST(TreeNode root) {
        return he(root,null,null);
    }
    private boolean he(TreeNode root,Integer lower,Integer upper){
        if(root==null)return true;
        int val=root.val;
        if(lower!=null&&lower>=val)return false;
        if(upper!=null&&upper<=val)return false;
        if(!he(root.left,lower,val))return false;
        if(!he(root.right,val,upper))return false;
        return true;
    }
	 */
}
