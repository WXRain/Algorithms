package medium;

import medium.RightSideView.TreeNode;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return preorder(0, inorder.length - 1, 0,
                postorder.length - 1, inorder, postorder);
    }

    private TreeNode preorder(int leftin, int rightin, int leftpost,
                              int rightpost, int[] inorder, int[] postorder) {
        if (leftin > rightin) return null;
        TreeNode root = new TreeNode(postorder[rightpost]);
        int rootin = leftin;
        while (rootin <= rightin && inorder[rootin] != postorder[rightpost])
            rootin++;
        int left = rootin - leftin;
        root.left = preorder(leftin, rootin - 1, leftpost,
                leftpost + left - 1, inorder, postorder);
        root.right = preorder(rootin + 1, rightin, leftpost + left,
                rightpost - 1, inorder, postorder);
        return root;
    }
}
